package org.rbnk.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.rbnk.example.domain.Cake;
import org.rbnk.example.entity.CakeEntity;
import org.rbnk.example.repository.impl.FakeRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CakeServiceTest {

    @Mock
    private FakeRepository cakeRepository;

    @InjectMocks
    private CakeService cakeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test get by id")
    void testGetById() {
        long cakeId = 13;
        CakeEntity cakeEntity = CakeEntity.builder()
                .id(cakeId)
                .build();
        when(cakeRepository.findById(cakeId)).thenReturn(Optional.of(cakeEntity));
        Cake cake = cakeService.getCakeById(cakeId);
        assertEquals(cakeId, cake.getId());
        verify(cakeRepository, times(1)).findById(cakeId);
    }

    @Test
    @DisplayName("Test get all")
    void testGetAll() {
        List<CakeEntity> cakeEntities = List.of(
                CakeEntity.builder()
                        .id(1)
                        .build(),
                CakeEntity.builder()
                        .id(2)
                        .build()
        );
        when(cakeRepository.findAll()).thenReturn(cakeEntities);
        List<Cake> cakes = cakeService.getAll();
        System.out.println(cakes);
        assertEquals(cakeEntities.size(), cakes.size());
        verify(cakeRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Test create cake")
    void testCreate(){
        Cake cake = Cake.builder()
                .id(13)
                .build();
        cakeService.create(cake);
        verify(cakeRepository,times(1)).save(any(CakeEntity.class));
    }

    @Test
    @DisplayName("Test update")
    void testUpdate(){
        Cake cake = Cake.builder()
                .id(13)
                .build();
        cakeService.update(cake);
        verify(cakeRepository,times(1)).save(any(CakeEntity.class));
    }

    @Test
    @DisplayName("Test update")
    void testDeleteDyId(){
        long id = 10;
        cakeService.deleteById(id);
        verify(cakeRepository,times(1)).delete(id);
    }
}