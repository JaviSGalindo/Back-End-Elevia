package com.elevia.backend_elevia.service;

import com.elevia.backend_elevia.model.VarianteProducto;

import java.util.List;

public interface IvarianteProductoService {
    //Metodo para obtener todas las variantes de productos
    List<VarianteProducto> getAllVarianteProducto();

    //Metodo para obtener una variante por id
    VarianteProducto getVarianteProductoById(Long id);

    //Metodo para crear una variante producto
    VarianteProducto createVarianteProducto(VarianteProducto varianteProducto);

    //Metodo para actualizar una variante producto
    VarianteProducto updateVarianteProducto(Long id, VarianteProducto varianteProducto);

    //Metodo para eliminar una variante producto
    void deleteVarianteProducto(Long id);
}
