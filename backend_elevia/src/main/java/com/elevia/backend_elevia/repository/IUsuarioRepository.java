package com.elevia.backend_elevia.repository;

import com.elevia.backend_elevia.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository  extends JpaRepository<Usuario, Long> {

}
