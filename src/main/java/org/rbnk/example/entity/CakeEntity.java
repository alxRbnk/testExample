package org.rbnk.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CakeEntity {
    private long id;
    private String name;
    private List<Ingredient> ingredients;
}
