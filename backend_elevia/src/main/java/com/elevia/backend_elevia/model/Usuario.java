package com.elevia.backend_elevia.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String direccion;
    private String contrasena;

    public Usuario(Long id, String nombre, String apellido, String telefono, String email, String direccion, String contrasena) {

    }

    public Usuario() {
    }

    public Object getContraseña() {
    }
}

