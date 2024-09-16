package org.rbnk.example.controller;

import lombok.RequiredArgsConstructor;
import org.rbnk.example.domain.Cake;
import org.rbnk.example.service.CakeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CakeController {

    private final CakeService cakeService;

    @GetMapping("/cakes")
    public ResponseEntity<List<Cake>> findAll() {
        List<Cake> cakes = cakeService.getAll();
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cakes);
    }

    @PostMapping("/add")
    public ResponseEntity<Cake> create(@RequestBody Cake cake) {
        cakeService.create(cake);
        return ResponseEntity
                .ok()
                .body(cake);
    }

}
