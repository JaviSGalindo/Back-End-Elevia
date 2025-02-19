package com.elevia.backend_elevia.service;

import com.elevia.backend_elevia.model.Usuario;
import com.elevia.backend_elevia.repository.IUsuarioRepository;
import com.elevia.backend_elevia.validator.GenericValidator;
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
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        genericValidator.validateId(id, "Usuario");

        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        genericValidator.validateExists(usuario, "variante producto");

        return usuario;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        genericValidator.validateExists(usuario, "usuario");

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario usuario) {
        genericValidator.validateId(id, "Usuario");
        genericValidator.validateExists(usuario, "Usuario");

        usuario.setNombre(usuario.getNombre());
        usuario.setApellido(usuario.getApellido());
        usuario.setContrasena(usuario.getContrasena());
        usuario.setDireccion(usuario.getDireccion());
        usuario.setTelefono(usuario.getTelefono());
        usuario.setEmail(usuario.getEmail());


        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        genericValidator.validateId(id, "Usuario");
        genericValidator.validateExists(getUsuarioById(id), "Usuario");

        usuarioRepository.deleteById(id);

    }


}
