package org.rbnk.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Ingredient {
    private String name;
    private Double count;
}
