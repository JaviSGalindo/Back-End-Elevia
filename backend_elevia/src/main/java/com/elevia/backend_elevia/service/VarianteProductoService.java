package com.elevia.backend_elevia.service;

import com.elevia.backend_elevia.model.VarianteProducto;
import com.elevia.backend_elevia.repository.IvarianteProductoRepository;
import com.elevia.backend_elevia.validator.GenericValidator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VarianteProductoService implements IvarianteProductoService {

    //Se instancia un validador generico
    private final GenericValidator genericValidator;
    private final IvarianteProductoRepository varianteProductoRepository;

    @Autowired
    public VarianteProductoService(GenericValidator genericValidator, IvarianteProductoRepository varianteProductoRepository) {
        this.genericValidator = genericValidator;
        this.varianteProductoRepository = varianteProductoRepository;
    }

    @Override
    public List<VarianteProducto> getAllVarianteProducto() {
        List<VarianteProducto> variantes = varianteProductoRepository.findAll();
        if (variantes.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron variantes de producto");
        }
        return variantes;
    }

    @Override
    public VarianteProducto getVarianteProductoById(Long id) {
        return genericValidator.validateEntityExists(id, "variante producto", varianteProductoRepository);
    }

    @Override
    public VarianteProducto createVarianteProducto(VarianteProducto varianteProducto) {
        if (varianteProducto.getStock_variante() == null) {
            throw new IllegalArgumentException("El stock de la variante de producto es obligatorio");
        }
        return varianteProductoRepository.save(varianteProducto);
    }

    @Override
    public VarianteProducto updateVarianteProducto(Long id, VarianteProducto varianteProducto) {
        VarianteProducto existingVariante = genericValidator.validateEntityExists(id, "variante producto", varianteProductoRepository);

        if (varianteProducto.getTalla() != null) {
            existingVariante.setTalla(varianteProducto.getTalla());
        }
        if (varianteProducto.getColor() != null) {
            existingVariante.setColor(varianteProducto.getColor());
        }
        if (varianteProducto.getStock_variante() != null) {
            existingVariante.setStock_variante(varianteProducto.getStock_variante());
        }

        return varianteProductoRepository.save(existingVariante);
    }


    @Override
    public void deleteVarianteProducto(Long id) {
        genericValidator.validateEntityExists(id, "variante producto", varianteProductoRepository);

        varianteProductoRepository.deleteById(id);
    }
}
