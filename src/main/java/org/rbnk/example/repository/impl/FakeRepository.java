package org.rbnk.example.repository.impl;

import org.rbnk.example.entity.CakeEntity;
import org.rbnk.example.repository.CakeRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FakeRepository implements CakeRepository {

    private final Map<Long, CakeEntity> dataBase = Map.of(
            1L, CakeEntity.builder()
                    .ingredients(List.of())
                    .build(),
            2L, CakeEntity.builder()
                    .ingredients(List.of())
                    .build()
    );

    public Optional<CakeEntity> findById(long id) {
        return Optional.ofNullable(dataBase.get(id));
    }

    public List<CakeEntity> findAll() {
        return dataBase.values().stream().toList();
    }

    public CakeEntity save(CakeEntity cakeEntity) {
        return cakeEntity;
    }

    public void delete(Long id) {
    }

}
