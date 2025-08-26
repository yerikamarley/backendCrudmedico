# Registros Médicos Backend

Backend en Spring Boot para gestión de usuarios (roles: Paciente/Médico), perfiles, citas y historiales médicos. Usa JPA/Hibernate con MySQL.

## Requisitos
- Java 17+
- Maven 3.8+
- MySQL 8.0+

## Instalación
1. Clona: `git clone https://github.com/tu-usuario/registros-medicos.git`
2. Configura `application.properties` con DB: `spring.datasource.url=jdbc:mysql://localhost:3306/registros?...`
3. Instala: `mvn clean install`

## Ejecución
- IDE: Ejecuta `RegistrosApplication.java`
- CLI: `mvn spring-boot:run`
- URL: `http://localhost:8080`

## Pruebas con Postman
- **Registro (POST /api/usuarios/registro)**:
  JSON para Paciente:
  ```json
  {
    "usuario": {"username": "pac1", "password": "pass", "rol": "PACIENTE"},
    "perfil": {"nombre": "Juan", "apellido": "Perez", "dni": "123", "telefono": "555", "email": "juan@ex.com"}
  }
  ```
- **Perfil por ID (GET /api/usuarios/1/perfil)**
- **Listar Usuarios (GET /api/usuarios)**

Endpoints: /api/pacientes, /api/medicos (CRUD).

## Estructura
- entity/: Modelos JPA
- repository/: Repos
- service/: Lógica
- controller/: APIs REST

Licencia: MIT
