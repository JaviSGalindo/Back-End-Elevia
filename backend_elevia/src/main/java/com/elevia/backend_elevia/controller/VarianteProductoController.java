package com.elevia.backend_elevia.controller;

import com.elevia.backend_elevia.model.VarianteProducto;
import com.elevia.backend_elevia.service.IvarianteProductoService;
import com.elevia.backend_elevia.service.VarianteProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/varianteproducto")
public class VarianteProductoController {

    private final IvarianteProductoService varianteProductoService;

    @Autowired
    public VarianteProductoController(IvarianteProductoService varianteProductoService) {
        this.varianteProductoService = varianteProductoService;
    }

    @GetMapping
    public ResponseEntity<List<VarianteProducto>> getAllVarianteProducto() {
        return ResponseEntity.ok(varianteProductoService.getAllVarianteProducto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VarianteProducto> getVarianteProductoById(@PathVariable Long id) {
        return ResponseEntity.ok(varianteProductoService.getVarianteProductoById(id));
    }

    @PostMapping
    public ResponseEntity<VarianteProducto> createVarianteProducto(@RequestBody VarianteProducto varianteProducto) {
        return ResponseEntity.ok(varianteProductoService.createVarianteProducto(varianteProducto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VarianteProducto> updateVarianteProducto(@PathVariable Long id, @RequestBody VarianteProducto varianteProducto) {
        return ResponseEntity.ok(varianteProductoService.updateVarianteProducto(id, varianteProducto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVarianteProducto(@PathVariable Long id) {
        varianteProductoService.deleteVarianteProducto(id);
        return ResponseEntity.noContent().build();
    }


}
