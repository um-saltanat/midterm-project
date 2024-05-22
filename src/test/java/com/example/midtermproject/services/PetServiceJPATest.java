package com.example.midtermproject.services;

import com.example.midtermproject.dto.PetDTO;
import com.example.midtermproject.entities.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PetServiceJPATest {

    @Autowired
    private PetServiceJPA petServiceJPA;

    @Test
    void convertEntityToDTO() {

        Pet pet = Pet.builder()
                .id(12L)
                .name("Pet 1")
                .species("Dog")
                .age(5)
                .build();

        PetDTO petDTO = petServiceJPA.convertEntityToDTO(pet);

        assertNotNull(petDTO);
        assertEquals(12L,petDTO.getId());
        assertEquals("Pet 1", petDTO.getName());
        assertEquals("Dog", petDTO.getSpecies());
        assertEquals(5, petDTO.getAge());

    }
}