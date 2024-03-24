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
@Table(name = "adopt_list")
public class AdoptList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resc_org_id", referencedColumnName = "id")
    private RescueOrg rescueOrg;

    @ManyToOne
    @JoinColumn(name = "pets_id", referencedColumnName = "id")
    private Pet pet;

    @Column(name = "adoption_status")
    private String adoptionStatus;


}
