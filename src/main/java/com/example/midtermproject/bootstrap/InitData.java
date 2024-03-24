package com.example.midtermproject.bootstrap;

import com.example.midtermproject.entities.AdoptList;
import com.example.midtermproject.entities.Pet;
import com.example.midtermproject.entities.RescueOrg;
import com.example.midtermproject.repositories.AdoptListRepository;
import com.example.midtermproject.repositories.PetRepository;
import com.example.midtermproject.repositories.RescueOrgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {

    private final PetRepository petRepository;
    private final RescueOrgRepository rescueOrgRepository;
    private final AdoptListRepository adoptListRepository;
    @Override
    public void run(String... args) {
        log.atWarn().log("Initializing data");

        RescueOrg org1 = RescueOrg.builder()
                .name("Paws & Claws")
                .address("Tipperary, Ireland")
                .build();

        RescueOrg org2 = RescueOrg.builder()
                .name("California Animal Rescue")
                .address("California")
                .build();

        rescueOrgRepository.saveAll(List.of(org1, org2));

        Pet pet1 = Pet.builder()
                .name("Garfield")
                .species("Cat")
                .breed("Abyssinian")
                .age(4)
                .gender("Male")
                .rescueOrg(org1)
                .build();

        Pet pet2 = Pet.builder()
                .name("Max")
                .species("Dog")
                .breed("Airedale terrier")
                .age(2)
                .gender("Female")
                .rescueOrg(org2)
                .build();

        Pet pet3 = Pet.builder()
                .name("Sonya")
                .species("Rabbit")
                .breed("Californian")
                .age(5)
                .gender("Female")
                .rescueOrg(org2)
                .build();

        petRepository.saveAll(List.of(pet1, pet2, pet3));

        AdoptList adoptList1 = AdoptList.builder()
                .pet(pet1)
                .rescueOrg(org1)
                .adoptionStatus("Available")
                .build();

        AdoptList adoptList2 = AdoptList.builder()
                .pet(pet2)
                .rescueOrg(org2)
                .adoptionStatus("Available")
                .build();

        AdoptList adoptList3 = AdoptList.builder()
                .pet(pet3)
                .rescueOrg(org2)
                .adoptionStatus("Taken")
                .build();

        adoptListRepository.saveAll(List.of(adoptList1, adoptList2, adoptList3));
    }
}
