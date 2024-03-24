package com.example.midtermproject.mappers;

import com.example.midtermproject.dto.RescueOrgDTO;
import com.example.midtermproject.entities.RescueOrg;
import org.mapstruct.Mapper;

@Mapper
public interface RescueOrgMapper {

    RescueOrg rescueOrgDTOToRescueOrg(RescueOrgDTO rescueOrgDTO);

    RescueOrgDTO rescueOrgToRescueOrgDTO(RescueOrg rescueOrg);
}
