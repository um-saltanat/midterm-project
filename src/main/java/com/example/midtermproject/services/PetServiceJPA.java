package com.example.midtermproject.services;

import com.example.midtermproject.controllers.NotFoundException;
import com.example.midtermproject.dto.PetDTO;
import com.example.midtermproject.entities.Pet;
import com.example.midtermproject.mappers.PetMapper;
import com.example.midtermproject.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetServiceJPA implements PetService{

    private final PetRepository petRepository;
    private final PetMapper petMapper;

    @Override
    public Optional<PetDTO> getPetByID(Long id) {
        return Optional.ofNullable(
                petMapper.petToPetDTO(
                        petRepository.findById(id)
                                .orElse(null)
                )
        );
    }

    @Override
    public PetDTO savePet(PetDTO petDTO) {

        Pet pet = petMapper.petDTOtoPet(petDTO);

        Pet savedPet = petRepository.save(pet);

        return petMapper.petToPetDTO(savedPet);
    }

    @Override
    public List<PetDTO> getAllPets() {
        return petRepository.findAll()
                .stream()
                .map(petMapper::petToPetDTO)
                .toList();
    }

    @Override
    public PetDTO updatePet(Long id, PetDTO pet) {
        Pet existingPet = petRepository.findById(id).orElse(null);
        if (existingPet == null) {
            throw new NotFoundException("Pet not found with id: " + id);
        }
        existingPet.setName(pet.getName());
        existingPet.setSpecies(pet.getSpecies());
        existingPet.setBreed(pet.getBreed());
        existingPet.setAge(pet.getAge());
        existingPet.setGender(pet.getGender());

        return petMapper.petToPetDTO(petRepository.save(existingPet));
    }


    @Override
    public void deletePet(Long id) {
        Pet petToDelete = petRepository.findById(id).orElse(null);
        if (petToDelete != null) {
            petRepository.delete(petToDelete);
        } else {
            throw new NotFoundException("Pet not found with id: " + id);
        }
    }

}
