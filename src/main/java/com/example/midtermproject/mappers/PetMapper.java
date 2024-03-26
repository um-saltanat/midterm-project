package com.example.midtermproject.mappers;

import com.example.midtermproject.dto.PetDTO;
import com.example.midtermproject.entities.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PetMapper {

    @Mapping(target = "rescueOrg.pets", ignore = true)
    Pet petDTOtoPet(PetDTO petDTO);

    @Mapping(target = "rescueOrg.pets", ignore = true)
    PetDTO petToPetDTO(Pet pet);
}
