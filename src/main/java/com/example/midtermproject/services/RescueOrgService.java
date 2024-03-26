package com.example.midtermproject.services;

import com.example.midtermproject.dto.RescueOrgDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RescueOrgService {

    Optional<RescueOrgDTO> getOrgByID(Long id);

    RescueOrgDTO saveOrg(RescueOrgDTO orgDTO);

    List<RescueOrgDTO> getAllOrg();

    RescueOrgDTO updateOrg(Long id, RescueOrgDTO orgDTO);

    void deleteOrg(Long id);

}
