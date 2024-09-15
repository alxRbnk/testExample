package org.rbnk.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Cake {
    private long id;
    private String name;
    private List<String> ingredients;
}


