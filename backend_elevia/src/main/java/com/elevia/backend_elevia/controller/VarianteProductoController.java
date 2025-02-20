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
        List<VarianteProducto> varianteProductoList = varianteProductoService.getAllVarianteProducto();
        if (varianteProductoList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(varianteProductoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VarianteProducto> getVarianteProductoById(@PathVariable Long id) {

        return ResponseEntity.ok(varianteProductoService.getVarianteProductoById(id));
    }

    @PostMapping
    public ResponseEntity<VarianteProducto> createVarianteProducto(@RequestBody VarianteProducto varianteProducto) {
        VarianteProducto varianteProductoCreated = varianteProductoService.createVarianteProducto(varianteProducto);
        return ResponseEntity.ok(varianteProductoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VarianteProducto> updateVarianteProducto(@PathVariable Long id, @RequestBody VarianteProducto varianteProducto) {
        VarianteProducto varianteProductoBeforeUpdate = varianteProductoService.getVarianteProductoById(id);

        VarianteProducto varianteProductoUpdated = varianteProductoService.updateVarianteProducto(id, varianteProducto);

        if (varianteProductoBeforeUpdate.equals(varianteProductoUpdated)) {
            return ResponseEntity.noContent().build(); // Si no hubo cambios, devolvemos HTTP 204
        }

        return ResponseEntity.ok(varianteProductoUpdated); // Si hubo cambios, devolvemos HTTP 200 con el recurso actualizado
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVarianteProducto(@PathVariable Long id) {
        varianteProductoService.deleteVarianteProducto(id);
        return ResponseEntity.noContent().build();
    }


}
