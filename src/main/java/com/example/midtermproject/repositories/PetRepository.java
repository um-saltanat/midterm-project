package com.example.midtermproject.repositories;

import com.example.midtermproject.entities.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Long> {

    List<Pet> findAll();
}
