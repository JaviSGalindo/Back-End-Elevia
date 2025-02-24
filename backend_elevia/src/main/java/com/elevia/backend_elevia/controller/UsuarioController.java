package com.elevia.backend_elevia.controller;

import com.elevia.backend_elevia.dto.UsuarioDTO;
import com.elevia.backend_elevia.jwt.JwtUtil;
import com.elevia.backend_elevia.mapper.UsuarioMapper;
import com.elevia.backend_elevia.service.IUsuarioService;
import com.elevia.backend_elevia.model.Usuario;
import com.elevia.backend_elevia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private  IUsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.getAllUsuario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.getUsuarioById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.createUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.updateUsuario(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);
        UserDetails userDetails = usuarioService.LoadByEmail(usuario.getEmail());

        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"El email no está registrado.\"}");
        }

        if (!passwordEncoder.matches(usuario.getContrasena(), userDetails.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"La contraseña es incorrecta.\"}");
        }

        String token = jwtUtil.generateToken(userDetails.getUsername());

        // Crear una respuesta sin incluir la contraseña

        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setToken(token);

        return ResponseEntity.ok(usuarioDTO);
    }

}
