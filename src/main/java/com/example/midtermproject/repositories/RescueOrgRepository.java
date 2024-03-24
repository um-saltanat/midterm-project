package com.example.midtermproject.repositories;

import com.example.midtermproject.entities.RescueOrg;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RescueOrgRepository extends CrudRepository<RescueOrg, Long> {
    List<RescueOrg> findAll();
}
