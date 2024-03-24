package com.example.midtermproject.repositories;

import com.example.midtermproject.entities.AdoptList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdoptListRepository extends CrudRepository<AdoptList, Long> {

    List<AdoptList> findAll();
}
