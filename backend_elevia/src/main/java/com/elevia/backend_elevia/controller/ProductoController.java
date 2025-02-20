package com.elevia.backend_elevia.controller;

import com.elevia.backend_elevia.model.Producto;
import com.elevia.backend_elevia.service.IproductoService;
import com.elevia.backend_elevia.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final IproductoService productoService;

    @Autowired
    public ProductoController(IproductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducto(){
        List<Producto> productoList = productoService.getAllProducto();
        if(productoList.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(productoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id){
        return ResponseEntity.ok(productoService.getProductoById(id));

    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto){
        Producto productoCreated = productoService.createProducto(producto);
        return ResponseEntity.ok(productoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto producto){
        Producto productoBeforeUpdate = productoService.getProductoById(id);

        Producto productoUpdated = productoService.updateProducto(id, producto);
        if(productoBeforeUpdate.equals(productoUpdated)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(productoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id){
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }

}
