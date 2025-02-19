package com.elevia.backend_elevia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_carrito;
    private Integer cantidad;

    public Carrito() {
    }

    public Carrito(Long id_carrito, Integer cantidad) {
        this.id_carrito = id_carrito;
        this.cantidad = cantidad;
    }

    public Long getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Long id_carrito) {
        this.id_carrito = id_carrito;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}

