package com.example.midtermproject.repositories;

import com.example.midtermproject.entities.RescueOrg;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RescueOrgRepositoryTest {

    @Autowired
    RescueOrgRepository rescueOrgRepository;

    @Test
    void testSavedRescueOrg(){
        RescueOrg savedOrg = rescueOrgRepository.save(RescueOrg.builder()
                .name("Organization A")
                .build());

        assertThat(savedOrg).isNotNull();
        assertThat(savedOrg.getId()).isNotNull();
    }

}