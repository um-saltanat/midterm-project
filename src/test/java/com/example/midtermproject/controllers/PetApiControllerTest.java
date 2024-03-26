package com.example.midtermproject.controllers;

import com.example.midtermproject.dto.PetDTO;
import com.example.midtermproject.services.PetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PetApiController.class)
class PetApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PetService petService;

    @Test
    void createPet() throws Exception {
        mockMvc.perform(post("/api/v1/pet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Garfield\",\"species\":\"Cat\",\"breed\":\"Abyssinian\",\"age\":4,\"gender\":\"Male\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void getPet() throws Exception {
        PetDTO petDTO = new PetDTO();
        petDTO.setId(1L);
        petDTO.setName("Garfield");
        petDTO.setSpecies("Cat");

        when(petService.getPetByID(anyLong())).thenReturn(java.util.Optional.of(petDTO));

        mockMvc.perform(get("/api/v1/pet/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Garfield"))
                .andExpect(jsonPath("$.species").value("Cat"));
    }

    @Test
    void getPets() throws Exception {
        when(petService.getAllPets()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/pet")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    void updatePet() throws Exception {
        mockMvc.perform(put("/api/v1/pet/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Garfield\",\"species\":\"Cat\",\"breed\":\"Abyssinian\",\"age\":4,\"gender\":\"Male\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deletePet() throws Exception {
        mockMvc.perform(delete("/api/v1/pet/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
