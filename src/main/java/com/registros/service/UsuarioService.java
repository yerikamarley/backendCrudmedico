package com.registros.service;

import com.registros.entity.Medico;
import com.registros.entity.Paciente;
import com.registros.entity.Usuario;
import com.registros.repository.MedicoRepository;
import com.registros.repository.PacienteRepository;
import com.registros.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PacienteRepository pacienteRepository, MedicoRepository medicoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Transactional
    public Usuario crearUsuarioConPerfil(Usuario usuario, Object perfil) {
        if (!Arrays.asList("PACIENTE", "MEDICO").contains(usuario.getRol())) {
            throw new IllegalArgumentException("Rol inválido: " + usuario.getRol());
        }

        usuario = usuarioRepository.save(usuario);

        if ("PACIENTE".equals(usuario.getRol())) {
            if (!(perfil instanceof Paciente)) {
                throw new IllegalArgumentException("Perfil debe ser Paciente para rol PACIENTE");
            }
            Paciente paciente = (Paciente) perfil;
            paciente.setUsuario(usuario);
            pacienteRepository.save(paciente);
            usuario.setPaciente(paciente);
        } else if ("MEDICO".equals(usuario.getRol())) {
            if (!(perfil instanceof Medico)) {
                throw new IllegalArgumentException("Perfil debe ser Medico para rol MEDICO");
            }
            Medico medico = (Medico) perfil;
            medico.setUsuario(usuario);
            medicoRepository.save(medico);
            usuario.setMedico(medico);
        }

        return usuarioRepository.save(usuario);
    }

    public Object getPerfilByUsuarioId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        return usuario.getPerfil();
    }

    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}