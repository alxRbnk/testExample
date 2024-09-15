package org.rbnk.example.service;

import lombok.AllArgsConstructor;
import org.rbnk.example.domain.Cake;
import org.rbnk.example.entity.CakeEntity;
import org.rbnk.example.mapper.CakeMapper;
import org.rbnk.example.repository.CakeRepository;

import java.util.List;


@AllArgsConstructor
public class CakeService {

    private final CakeRepository cakeRepository;

    public List<Cake> getAll() {
        return CakeMapper.INSTANCE.toDomains(cakeRepository.findAll());
    }

    public Cake getCakeById(Long id) {
        return cakeRepository.findById(id)
                .map(CakeMapper.INSTANCE::toDomain)
                .orElseThrow(() -> new RuntimeException("Cake not found"));
    }

    public Cake create(Cake cake) {
        CakeEntity entity = CakeMapper.INSTANCE.toEntity(cake);
        cakeRepository.save(entity);
        return cake;
    }

    public Cake update(Cake cake) {
        CakeEntity entity = CakeMapper.INSTANCE.toEntity(cake);
        cakeRepository.save(entity);
        return cake;
    }

    public void deleteById(Long id) {
        cakeRepository.delete(id);
    }


}
