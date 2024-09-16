package org.rbnk.example.controller;

import org.junit.jupiter.api.Test;
import org.rbnk.example.domain.Cake;
import org.rbnk.example.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CakeControllerTest {

    @MockBean
    private CakeService cakeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldFindAllCakes() throws Exception {
        when(cakeService.getAll())
                .thenReturn(List.of(Cake.builder().build(),
                        Cake.builder().build()));
        mockMvc.perform(get("/api/v1/cakes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }
}