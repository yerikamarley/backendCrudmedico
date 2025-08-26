package com.registros.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String rol; 

    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY, optional = true)
    private Paciente paciente; 

    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY, optional = true)
    private Medico medico; 

        public Object getPerfil() {
        if ("PACIENTE".equals(rol)) {
            return paciente;
        } else if ("MEDICO".equals(rol)) {
            return medico;
        }
        return null; 
        }

		public Object getRol() {
			
			return null;
		}

		public void setMedico(Medico medico2) {
			// TODO Auto-generated method stub
			
		}

		public void setPaciente(Paciente paciente2) {
			// TODO Auto-generated method stub
			
		}
}
        