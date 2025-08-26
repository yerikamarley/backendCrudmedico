package com.registros.controller;

import com.registros.entity.Especialidad;
import com.registros.service.EspecialidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {

    private final EspecialidadService especialidadService;

    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @GetMapping
    public List<Especialidad> getAll() {
        return especialidadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> getById(@PathVariable Long id) {
        Optional<Especialidad> especialidad = especialidadService.findById(id);
        return especialidad.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Especialidad create(@RequestBody Especialidad especialidad) {
        return especialidadService.save(especialidad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        especialidadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
