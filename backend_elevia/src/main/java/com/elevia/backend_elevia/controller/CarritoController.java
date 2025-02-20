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

    @Autowired
    private final CarritoService carritoservice;

    public CarritoController(CarritoService carritoservice) {
        this.carritoservice = carritoservice;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> getcarritoById(@PathVariable Long id){
        Carrito carrito = carritoservice.getCarritoById(id);
        return carrito != null ? ResponseEntity.ok(carrito):ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Carrito> crearCarrito(@RequestBody Carrito carrito){
        Carrito carritocreated = carritoservice.createCarrito(carrito);
        return carritocreated != null ? ResponseEntity.ok(carritocreated): ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> updateCarrito(@PathVariable Long id, @RequestBody Carrito carrito){
        Carrito carritoForUpdate = carritoservice.getCarritoById(id);
        if()
        return carritoForUpdate != null ? ResponseEntity.ok()(carritoUpdate): ResponseEntity.notFound().build();
    }

}
