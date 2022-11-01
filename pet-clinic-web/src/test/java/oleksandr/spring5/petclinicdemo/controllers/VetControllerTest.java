package oleksandr.spring5.petclinicdemo.controllers;

import oleksandr.spring5.petclinicdemo.model.Pet;
import oleksandr.spring5.petclinicdemo.model.Vet;
import oleksandr.spring5.petclinicdemo.repositories.PetRepository;
import oleksandr.spring5.petclinicdemo.repositories.VetRepository;
import oleksandr.spring5.petclinicdemo.services.VetService;
import oleksandr.spring5.petclinicdemo.services.springdatajpa.PetSDJpdaService;
import oleksandr.spring5.petclinicdemo.services.springdatajpa.VetSDJpaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {
    @Mock
    VetService vetService;

    @InjectMocks
    VetController vetController;

    Vet vet;
    MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        //actually as for this functionality Before test is not needed
        vet = Vet.builder().id(1L).build();
        mockMvc = MockMvcBuilders.standaloneSetup(vetController).build();

    }

    @Test
    void listVets() throws Exception {
        Set<Vet> vets = new HashSet<>();
        vets.add(vet);
        vets.add(Vet.builder().id(2L).build());
        vets.add(Vet.builder().id(3L).build());
        when(vetService.findAll()).thenReturn(vets);
        mockMvc.perform(get("/vets"))
                .andExpect(status().isOk())
                .andExpect(view().name("vets/index"))
                .andExpect(model().attribute("vets",hasSize(3)));

    }
}