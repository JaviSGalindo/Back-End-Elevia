package com.elevia.backend_elevia.service;

import com.elevia.backend_elevia.model.Carrito;

public interface IcarritoService {
    Carrito getCarritoById(Long id);

    Carrito createCarrito(Carrito carrito);

    Carrito updateCarrito(Long id, Carrito carrito);

    void deleteCarrito(Long id);
}
