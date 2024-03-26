package com.example.midtermproject.services;

import com.example.midtermproject.controllers.NotFoundException;
import com.example.midtermproject.dto.RescueOrgDTO;
import com.example.midtermproject.entities.RescueOrg;
import com.example.midtermproject.mappers.RescueOrgMapper;
import com.example.midtermproject.repositories.RescueOrgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RescueOrgServiceJPA implements RescueOrgService{

    private final RescueOrgMapper orgMapper;
    private final RescueOrgRepository orgRepository;

    @Override
    public Optional<RescueOrgDTO> getOrgByID(Long id) {
        return Optional.ofNullable(
                orgMapper.rescueOrgToRescueOrgDTO(
                        orgRepository.findById(id)
                                .orElse(null)
                )
        );
    }

    @Override
    public RescueOrgDTO saveOrg(RescueOrgDTO orgDTO) {

        RescueOrg rescueOrg = orgMapper.rescueOrgDTOToRescueOrg(orgDTO);
        RescueOrg savedOrg = orgRepository.save(rescueOrg);
        return orgMapper.rescueOrgToRescueOrgDTO(savedOrg);
    }

    @Override
    public List<RescueOrgDTO> getAllOrg() {
        return orgRepository.findAll()
                .stream()
                .map(orgMapper::rescueOrgToRescueOrgDTO)
                .toList();
    }

    @Override
    public RescueOrgDTO updateOrg(Long id, RescueOrgDTO orgDTO) {
        RescueOrg existingOrg = orgRepository.findById(id).orElse(null);
        if (existingOrg == null) {
            throw new NotFoundException("Rescue organization not found with id: " + id);
        }
        existingOrg.setName(orgDTO.getName());
        existingOrg.setAddress(orgDTO.getAddress());

        return orgMapper.rescueOrgToRescueOrgDTO(orgRepository.save(existingOrg));
    }

    @Override
    public void deleteOrg(Long id) {
        RescueOrg orgToDelete = orgRepository.findById(id).orElse(null);
        if (orgToDelete != null) {
            orgRepository.delete(orgToDelete);
        } else {
            throw new NotFoundException("Rescue organization not found with id: " + id);
        }
    }
}
