package com.elevia.backend_elevia.service;

import com.elevia.backend_elevia.model.Usuario;
import com.elevia.backend_elevia.repository.IUsuarioRepository;
import com.elevia.backend_elevia.validator.GenericValidator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    //Se instancia un validador genérico
    private final GenericValidator genericValidator;
    private final IUsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(GenericValidator genericValidator, IUsuarioRepository usuarioRepository) {
        this.genericValidator = genericValidator; //Se agrega al constructor
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getAllUsuario() {
        List<Usuario> usuarios= usuarioRepository.findAll();
        if (usuarios.isEmpty()){
            throw new EntityNotFoundException("No se encontraron usuarios");
        }
        return usuarios;
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return  genericValidator.validateEntityExists(id,"usuario", usuarioRepository);
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        if (usuario.getNombre() == null || usuario.getApellido() == null ||
                usuario.getContraseña() == null || usuario.getDireccion() == null ||
                usuario.getTelefono() == null || usuario.getEmail() == null) {
            throw new IllegalArgumentException("Todos los campos del usuario son obligatorios");
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario usuario) {
        Usuario existingUsuario = genericValidator.validateEntityExists(id, "usuario", usuarioRepository);

        if (usuario.getNombre() != null) {
            existingUsuario.setNombre(usuario.getNombre());
        }
        if (usuario.getApellido() != null) {
            existingUsuario.setApellido(usuario.getApellido());
        }
        if (usuario.getDireccion() != null) {
            existingUsuario.setDireccion(usuario.getDireccion());
        }
        if (usuario.getTelefono() != null) {
            existingUsuario.setTelefono(usuario.getTelefono());
        }
        if (usuario.getEmail() != null) {
            existingUsuario.setEmail(usuario.getEmail());
        }

        return usuarioRepository.save(existingUsuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        genericValidator.validateEntityExists(id, "Usuario", usuarioRepository);
        usuarioRepository.deleteById(id);

    }
}
