package com.registros.repository;

import com.registros.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

   
    @Query("SELECT m FROM Medico m WHERE m.usuario.id = :id")
    Medico findByUsuarioId(@Param("id") Long id);
}