package com.example.midtermproject.mappers;

import com.example.midtermproject.dto.PetDTO;
import com.example.midtermproject.entities.Pet;
import org.mapstruct.Mapper;

@Mapper
public interface PetMapper {

    Pet petDTOtoPet(PetDTO petDTO);

    PetDTO petToPetDTO(Pet pet);
}
