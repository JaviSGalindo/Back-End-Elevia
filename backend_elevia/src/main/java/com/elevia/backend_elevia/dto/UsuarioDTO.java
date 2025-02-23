package com.elevia.backend_elevia.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    public String email;
    public String contrasena;
    private String token;

    public UsuarioDTO(String email, String contrasena) {
        this.email = email;
        this.contrasena = contrasena;
    }

    public UsuarioDTO() {
    }

}
