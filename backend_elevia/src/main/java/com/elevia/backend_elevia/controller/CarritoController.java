package com.elevia.backend_elevia.controller;

import com.elevia.backend_elevia.model.Carrito;
import com.elevia.backend_elevia.service.CarritoService;
import com.elevia.backend_elevia.service.IcarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carritos")
public class CarritoController {


    private final CarritoService carritoservice;

    @Autowired
    public CarritoController(CarritoService carritoservice) {
        this.carritoservice = carritoservice;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> getcarritoById(@PathVariable Long id){
        return  ResponseEntity.ok(carritoservice.getCarritoById(id));
    }

    @PostMapping
    public ResponseEntity<Carrito> crearCarrito(@RequestBody Carrito carrito){
        return ResponseEntity.ok(carritoservice.createCarrito(carrito));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> updateCarrito(@PathVariable Long id, @RequestBody Carrito carrito) {
        return ResponseEntity.ok(carritoservice.updateCarrito(id,carrito)); //
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletecarrito(@PathVariable Long id) {
        carritoservice.deleteCarrito(id);
        return ResponseEntity.noContent().build();
    }

}
