package com.example.midtermproject.dto;

import com.example.midtermproject.entities.RescueOrg;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String species;
    private String breed;
    private Integer age;
    private String gender;

    private RescueOrg rescueOrg;
}
