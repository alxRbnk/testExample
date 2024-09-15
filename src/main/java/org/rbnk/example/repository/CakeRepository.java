package org.rbnk.example.repository;

import org.rbnk.example.entity.CakeEntity;

import java.util.List;
import java.util.Optional;

public interface CakeRepository {

    Optional<CakeEntity> findById(long id);

    List<CakeEntity> findAll();

    CakeEntity save(CakeEntity cakeEntity);

    void delete(Long id);

}
