package com.elevia.backend_elevia.repository;

import com.elevia.backend_elevia.model.VarianteProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IvarianteProductoRepository extends JpaRepository<VarianteProducto, Long> {
}
