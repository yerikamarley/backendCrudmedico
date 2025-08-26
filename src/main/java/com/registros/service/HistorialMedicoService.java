package com.registros.service;

import com.registros.entity.HistorialMedico;
import com.registros.repository.HistorialMedicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HistorialMedicoService {

    private final HistorialMedicoRepository historialRepository;

    public HistorialMedicoService(HistorialMedicoRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    public List<HistorialMedico> findAll() {
        return historialRepository.findAll();
    }

    public Optional<HistorialMedico> findById(Long id) {
        return historialRepository.findById(id);
    }

    public HistorialMedico save(HistorialMedico historial) {
        return historialRepository.save(historial);
    }

    public void deleteById(Long id) {
        historialRepository.deleteById(id);
    }
}
