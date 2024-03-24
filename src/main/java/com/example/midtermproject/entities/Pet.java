package com.example.midtermproject.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String species;
    private String breed;
    private Integer age;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "rescue_org_id", referencedColumnName = "id")
    private RescueOrg rescueOrg;


}
