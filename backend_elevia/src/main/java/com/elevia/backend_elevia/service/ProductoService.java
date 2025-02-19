package com.elevia.backend_elevia.service;

import com.elevia.backend_elevia.model.Producto;
import com.elevia.backend_elevia.repository.IproductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IproductoService {
    private final IproductoRepository iproductRepository;

    @Autowired

    @Override
    public List<Producto> getAllProducto() {
        return List.of();
    }

    @Override
    public Producto getProductoById(Long id) {
        return null;
    }

    @Override
    public Producto createProducto(Producto producto) {

    }

    @Override
    public Producto updateProducto(Long id, Producto producto) {
        return null;
    }

    @Override
    public void deleteProducto(Long id) {

    }
}
