package com.example.midtermproject.mappers;

import com.example.midtermproject.dto.PetDTO;
import com.example.midtermproject.entities.Pet;
import com.example.midtermproject.entities.RescueOrg;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PetMapperTest {

    @Autowired
    PetMapper petMapper;

    @Test
    void petDTOtoPet() {

        PetDTO petDTO = PetDTO.builder()
                .id(33L)
                .name("Sam")
                .species("Cat")
                .breed("Siamese")
                .build();

        Pet pet = petMapper.petDTOtoPet(petDTO);

        assertNotNull(pet);
        assertEquals(33L,pet.getId());
        assertEquals("Sam", pet.getName());
        assertEquals("Siamese", pet.getBreed());
    }

    @Test
    void petToPetDTO() {

        RescueOrg rescueOrg = RescueOrg.builder()
                .name("Organization 1")
                .build();

        Pet pet = Pet.builder()
                .id(7L)
                .name("Whiskers")
                .species("Cat")
                .age(10)
                .gender("Male")
                .rescueOrg(rescueOrg)
                .build();

        PetDTO petDTO = petMapper.petToPetDTO(pet);

        assertNotNull(petDTO);
        assertEquals(7L,petDTO.getId());
        assertEquals("Whiskers", petDTO.getName());
        assertEquals(10, petDTO.getAge());
        assertNotNull(petDTO.getRescueOrg());
        assertEquals("Organization 1", petDTO.getRescueOrg().getName());
    }
}