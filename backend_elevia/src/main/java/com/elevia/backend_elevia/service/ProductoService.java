package com.elevia.backend_elevia.service;

import com.elevia.backend_elevia.model.Producto;
import com.elevia.backend_elevia.repository.IproductoRepository;
import com.elevia.backend_elevia.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IproductoService {
    //Se instancia un validador generico
    private final GenericValidator genericValidator;
    private final IproductoRepository productoRepository;

    @Autowired
    public ProductoService(GenericValidator genericValidator, IproductoRepository productoRepository){
        this.genericValidator = genericValidator;
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> getAllProducto() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProductoById(Long id) {
        genericValidator.validateId(id, "producto");

        Producto producto = productoRepository.findById(id).orElse(null);

        genericValidator.validateExists(producto, "producto");

        return  producto;
    }

    @Override
    public Producto createProducto(Producto producto) {
        genericValidator.validateExists(producto, "producto");

        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Long id, Producto producto) {
        genericValidator.validateId(id, "producto");
        genericValidator.validateExists(producto, "producto");

        producto.setNombre(producto.getNombre());
        producto.setDescripcion(producto.getDescripcion());
        producto.setCategoria(producto.getCategoria());
        producto.setImagen_producto(producto.getImagen_producto());
        producto.setStock(producto.getStock());
        producto.setPrecio(producto.getPrecio());

        return productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        genericValidator.validateId(id, "producto");
        genericValidator.validateExists(getProductoById(id), "producto");

        productoRepository.deleteById(id);
    }
}
