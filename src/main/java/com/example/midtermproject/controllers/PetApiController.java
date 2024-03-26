package com.example.midtermproject.controllers;

import com.example.midtermproject.dto.PetDTO;
import com.example.midtermproject.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pet")
public class PetApiController {

    private final PetService petService;

    @PostMapping
    public ResponseEntity<PetDTO> createPet(@Validated @RequestBody PetDTO pet) {
        pet.setId(null);
        PetDTO savedPet = petService.savePet(pet);
        return ResponseEntity
                .created(URI.create("/api/v1/pet/" + savedPet.getId()))
                .body(savedPet);
    }

    @GetMapping("/{id}")
    public PetDTO getPet(@PathVariable Long id) {
        return petService.getPetByID(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Resource with id:%d Not Found", id)
                ));
    }

    @GetMapping
    public List<PetDTO> getPets() {
        return petService.getAllPets();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDTO> updatePet(@PathVariable Long id, @Validated @RequestBody PetDTO petDTO) {
        petService.getPetByID(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Pet with id %d not found", id)
                ));
        petDTO.setId(id);
        PetDTO updatedPet = petService.savePet(petDTO);
        return ResponseEntity.ok(updatedPet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.getPetByID(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Pet with id %d not found", id)
                ));
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }

}
