package com.registros.service;

import com.registros.entity.Receta;
import com.registros.repository.RecetaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecetaService {

    private final RecetaRepository recetaRepository;

    public RecetaService(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    public List<Receta> findAll() {
        return recetaRepository.findAll();
    }

    public Optional<Receta> findById(Long id) {
        return recetaRepository.findById(id);
    }

    public Receta save(Receta receta) {
        return recetaRepository.save(receta);
    }

    public void deleteById(Long id) {
        recetaRepository.deleteById(id);
    }
}
