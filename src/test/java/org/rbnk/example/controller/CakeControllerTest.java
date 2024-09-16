package org.rbnk.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.rbnk.example.domain.Cake;
import org.rbnk.example.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CakeController.class)
class CakeControllerTest {

    @MockBean
    private CakeService cakeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test find all cakes")
    void shouldFindAllCakes() throws Exception {
        when(cakeService.getAll())
                .thenReturn(List.of(Cake.builder().id(12).build(),
                        Cake.builder().id(13).build()));
        mockMvc.perform(get("/api/v1/cakes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    @DisplayName("Test create cake")
    void shouldCreateCake() throws Exception {
        Cake cake = Cake.builder().id(1L).name("Chocolate Cake").build();
        when(cakeService.create(any(Cake.class))).thenReturn(cake);
        mockMvc.perform(post("/api/v1/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(cake)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Chocolate Cake"));
        verify(cakeService, times(1)).create(any(Cake.class));
    }
}