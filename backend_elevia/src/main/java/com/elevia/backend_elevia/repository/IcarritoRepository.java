package com.elevia.backend_elevia.repository;

import com.elevia.backend_elevia.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcarritoRepository extends JpaRepository<Carrito, Long> {
}
