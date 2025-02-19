package com.elevia.backend_elevia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id_producto;
    private String nombre;
    private String descripcion;
    private String categoria;
    private String imagen_producto;
    private int stock;
    private double precio;

    public Producto() {
    }

    public Producto(Long id_producto, String nombre, String descripcion, String categoria, String imagen_producto, int stock, double precio) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.imagen_producto = imagen_producto;
        this.stock = stock;
        this.precio = precio;
    }
}
