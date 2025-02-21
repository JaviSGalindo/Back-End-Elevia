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
        return genericValidator.validateEntityExists(id, "carrito", carritoRepository);

    }

    @Override
    public Carrito createCarrito(Carrito carrito) {
        if (carrito.getCantidad() == null){
            throw  new IllegalArgumentException("La cantidad es necesaria");
        }
        return carritoRepository.save(carrito);
    }

    @Override
    public Carrito updateCarrito(Long id, Carrito carrito) {
        genericValidator.validateEntityExists(id, "carrito", carritoRepository);

        if (carrito.getCantidad() != null){
            carrito.setCantidad(carrito.getCantidad());
        }
        return carritoRepository.save(carrito);
    }

    @Override
    public void deleteCarrito(Long id) {
        genericValidator.validateEntityExists(id, "carrito", carritoRepository);
        carritoRepository.deleteById(id);

    }
}
