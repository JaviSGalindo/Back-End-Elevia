package com.elevia.backend_elevia.service;

import com.elevia.backend_elevia.model.Carrito;
import com.elevia.backend_elevia.model.VarianteProducto;
import com.elevia.backend_elevia.repository.IcarritoRepository;
import com.elevia.backend_elevia.repository.IvarianteProductoRepository;
import com.elevia.backend_elevia.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoService implements IcarritoService{

    //Se instancia un validador genérico
    private final GenericValidator genericValidator;
    private final IcarritoRepository carritoRepository;

    @Autowired
    public CarritoService(GenericValidator genericValidator, IcarritoRepository carritoRepository) {
        this.genericValidator = genericValidator; //Se agrega al constructor
        this.carritoRepository = carritoRepository;
    }

    @Override
    public Carrito getCarritoById(Long id) {
        genericValidator.validateId(id, "Carrito");

        Carrito carrito = carritoRepository.findById(id).orElse(null);
        genericValidator.validateExists(carrito, "Carrito");
        return carrito;
    }

    @Override
    public Carrito createCarrito(Carrito carrito) {
        genericValidator.validateExists(carrito, "Carrito");
        return carritoRepository.save(carrito);
    }

    @Override
    public Carrito updateCarrito(Long id, Carrito carrito) {
        genericValidator.validateId(id, "Carrito");
        genericValidator.validateExists(carrito, "Carrito");

        carrito.setCantidad(carrito.getCantidad());
        return carritoRepository.save(carrito);
    }

    @Override
    public void deleteCarrito(Long id) {
        genericValidator.validateId(id, "Carrito");
        genericValidator.validateExists(getCarritoById(id), "Carrito");

        carritoRepository.deleteById(id);
    }
}
