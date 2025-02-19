package com.elevia.backend_elevia.service;

import com.elevia.backend_elevia.model.Producto;
import java.util.List;

public interface IproductoService {
    //Metodo para obtener todas las s de productos
    List<Producto> getAllProducto();

    //Metodo para obtener una  por id
    Producto getProductoById(Long id);

    //Metodo para crear una  producto
    Producto createProducto(Producto Producto;

    //Metodo para actualizar una  producto
    Producto updateProducto(Long id, Producto Producto);

    //Metodo para eliminar una  producto
    void deleteProducto(Long id);
}
