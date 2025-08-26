package com.registros.controller;

import com.registros.entity.Receta;
import com.registros.service.RecetaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recetas")
public class RecetaController {

    private final RecetaService recetaService;

    public RecetaController(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    @GetMapping
    public List<Receta> getAll() {
        return recetaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receta> getById(@PathVariable Long id) {
        Optional<Receta> receta = recetaService.findById(id);
        return receta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Receta create(@RequestBody Receta receta) {
        return recetaService.save(receta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        recetaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
