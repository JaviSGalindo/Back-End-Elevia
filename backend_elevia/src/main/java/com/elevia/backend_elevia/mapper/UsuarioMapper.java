package com.elevia.backend_elevia.mapper;

import com.elevia.backend_elevia.dto.UsuarioDTO;
import com.elevia.backend_elevia.model.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        return new UsuarioDTO(
                usuario.getEmail(),
                usuario.getContrasena()
        );
    }

    public static Usuario toEntity(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            return null;
        }

        return new Usuario(
                usuarioDTO.getEmail(),
                usuarioDTO.getContrasena()
        );
    }
}
