package com.elevia.backend_elevia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito;
    private Long usuario_id;
    private Long variante_producto_id;
    private int cantidad;

    public Carrito() {
    }

    public Carrito(Long id_carrito, Long usuario_id, Long variante_producto_id, int cantidad) {
        this.id_carrito = id_carrito;
        this.usuario_id = usuario_id;
        this.variante_producto_id = variante_producto_id;
        this.cantidad = cantidad;
    }
}

