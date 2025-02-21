package com.elevia.backend_elevia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class VarianteProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_variante_productos;
    private Long producto_id;
    private String talla;
    private String color;
    private Integer stock_variante;

    public VarianteProducto(Long id_variante_productos, Long producto_id, String talla, String color, Integer stock_variante) {
        this.id_variante_productos = id_variante_productos;
        this.producto_id = producto_id;
        this.talla = talla;
        this.color = color;
        this.stock_variante = stock_variante;
    }

    public VarianteProducto() {
    }
}
