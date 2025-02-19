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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_variante_productos;
    private Long producto_id;
    private String talla;
    private String color;
    private int stock_variante;

    public VarianteProducto(Long id_variante_productos, Long producto_id, String talla, String color, int stock_variante) {
        this.id_variante_productos = id_variante_productos;
        this.producto_id = producto_id;
        this.talla = talla;
        this.color = color;
        this.stock_variante = stock_variante;
    }

    public VarianteProducto() {
    }
}
