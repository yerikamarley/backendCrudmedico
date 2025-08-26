package com.registros.controller;

import com.registros.entity.HistorialMedico;
import com.registros.service.HistorialMedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historiales")
public class HistorialMedicoController {

    private final HistorialMedicoService historialMedicoService;

    public HistorialMedicoController(HistorialMedicoService historialMedicoService) {
        this.historialMedicoService = historialMedicoService;
    }

    @GetMapping
    public List<HistorialMedico> getAll() {
        return historialMedicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialMedico> getById(@PathVariable Long id) {
        Optional<HistorialMedico> historial = historialMedicoService.findById(id);
        return historial.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HistorialMedico create(@RequestBody HistorialMedico historial) {
        return historialMedicoService.save(historial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        historialMedicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
