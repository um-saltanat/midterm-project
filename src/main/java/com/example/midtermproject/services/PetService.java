package com.example.midtermproject.services;

import com.example.midtermproject.dto.PetDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PetService {


    Optional<PetDTO> getPetByID(Long id);

    PetDTO savePet(PetDTO pet);

    List<PetDTO> getAllPets();

    PetDTO updatePet(Long id, PetDTO pet);

    void deletePet(Long id);
}
