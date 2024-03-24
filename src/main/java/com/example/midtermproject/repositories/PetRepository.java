package com.example.midtermproject.repositories;

import com.example.midtermproject.entities.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Long, Pet> {
}
