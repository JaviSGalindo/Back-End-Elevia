package com.elevia.backend_elevia.service;

import com.elevia.backend_elevia.model.Usuario;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface IUsuarioService {
    //Metodo para obtener todas los usuario
    List<Usuario> getAllUsuario();

    //Metodo para obtener un usuario por id
    Usuario getUsuarioById(Long id);

    //Metodo para crear un Usuario
    Usuario createUsuario(Usuario usuario);

    //Metodo para actualizar una variante producto
    Usuario updateUsuario(Long id, Usuario usuario);

    //Metodo para eliminar un usuario
    void deleteUsuario(Long id);

    //Metodo para encontrar usuario por correo
    User LoadByEmail(String email);


}
