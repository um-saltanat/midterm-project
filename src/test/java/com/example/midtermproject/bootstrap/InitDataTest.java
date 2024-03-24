package com.example.midtermproject.bootstrap;

import com.example.midtermproject.repositories.AdoptListRepository;
import com.example.midtermproject.repositories.PetRepository;
import com.example.midtermproject.repositories.RescueOrgRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InitDataTest {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private RescueOrgRepository rescueOrgRepository;

    @Autowired
    private AdoptListRepository adoptListRepository;

    @Autowired
    private InitData initData;

    @BeforeEach
    public void setUp() {
        if (!isDataInitialized()) {
            initData.run();
        }
    }

    private boolean isDataInitialized() {
        return rescueOrgRepository.count() > 0 && petRepository.count() > 0 && adoptListRepository.count() > 0;
    }

    @Test
    public void run(){

        assertNotNull(rescueOrgRepository);
        assertEquals(2, rescueOrgRepository.count());

        assertNotNull(petRepository);
        assertEquals(3, petRepository.count());

        assertNotNull(adoptListRepository);
        assertEquals(3, adoptListRepository.count());
    }

}