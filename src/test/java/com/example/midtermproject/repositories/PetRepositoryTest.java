package com.example.midtermproject.repositories;

import com.example.midtermproject.entities.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PetRepositoryTest {

    @Autowired
    PetRepository petRepository;

    @Test
    void testSavePet(){
        Pet savedPet = petRepository.save(Pet.builder()
                .name("Rosha")
                .build());

        assertThat(savedPet).isNotNull();
        assertThat(savedPet.getId()).isNotNull();
    }
}