package com.elevia.backend_elevia.service;

import com.elevia.backend_elevia.model.Producto;
import com.elevia.backend_elevia.repository.IproductoRepository;
import com.elevia.backend_elevia.repository.IvarianteProductoRepository;
import com.elevia.backend_elevia.validator.GenericValidator;
import jakarta.persistence.EntityNotFoundException;
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
        List<Producto> productos = productoRepository.findAll();
        if (productos.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron productos");
        }
        return productos;
    }

    @Override
    public Producto getProductoById(Long id) {
        return genericValidator.validateEntityExists(id, "producto", productoRepository);
    }

    @Override
    public Producto createProducto(Producto producto) {
        if (producto.getNombre() == null){
            throw  new IllegalArgumentException("El nombre de producto es necesario");
        }
        if (producto.getDescripcion() == null){
            throw  new IllegalArgumentException("La descricion de producto es necesaria");
        }
        if (producto.getCategoria() == null){
            throw  new IllegalArgumentException("La categoria de producto es necesaria");
        }
        if (producto.getImagen_producto() == null){
            throw  new IllegalArgumentException("La imagen de producto es necesaria");
        }
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Long id, Producto producto) {
        genericValidator.validateEntityExists(id, "producto", productoRepository);

        if (producto.getNombre() != null){
            producto.setNombre(producto.getNombre());
        }
        if (producto.getDescripcion() != null){
            producto.setDescripcion(producto.getDescripcion());
        }
        if (producto.getCategoria() != null){
            producto.setCategoria(producto.getCategoria());
        }
        if (producto.getImagen_producto() != null){
            producto.setImagen_producto(producto.getImagen_producto());
        }
        if (producto.getStock() != null){
            producto.setStock(producto.getStock());
        }
        if (producto.getPrecio() != null) producto.setPrecio(producto.getPrecio());

        return productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        genericValidator.validateEntityExists(id, "producto", productoRepository);

        productoRepository.deleteById(id);
    }
}
