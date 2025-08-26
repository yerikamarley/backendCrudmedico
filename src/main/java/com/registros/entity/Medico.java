package com.registros.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidad especialidad;

   
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", unique = true) 
    private Usuario usuario;


	public void setUsuario(Usuario usuario2) {
		// TODO Auto-generated method stub
		
	}
}