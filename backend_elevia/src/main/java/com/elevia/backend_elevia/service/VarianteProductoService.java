package com.elevia.backend_elevia.service;

import com.elevia.backend_elevia.model.VarianteProducto;
import com.elevia.backend_elevia.repository.IvarianteProductoRepository;
import com.elevia.backend_elevia.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VarianteProductoService implements IvarianteProductoService {
    //Se instancia un validador genérico
    private final GenericValidator genericValidator;
    private final IvarianteProductoRepository varianteProductoRepository;

    @Autowired
    public VarianteProductoService(GenericValidator genericValidator, IvarianteProductoRepository varianteProductoRepository) {
        this.genericValidator = genericValidator;
        this.varianteProductoRepository = varianteProductoRepository;
    }

    @Override
    public List<VarianteProducto> getAllVarianteProducto() {
        return varianteProductoRepository.findAll();
    }

    @Override
    public VarianteProducto getVarianteProductoById(Long id) {
        genericValidator.validateId(id, "variante producto");

        VarianteProducto varianteProducto = varianteProductoRepository.findById(id).orElse(null);

        genericValidator.validateExists(varianteProducto, "variante producto");

        return varianteProducto;
    }

    @Override
    public VarianteProducto createVarianteProducto(VarianteProducto varianteProducto) {
        genericValidator.validateExists(varianteProducto, "variante producto");

        return varianteProductoRepository.save(varianteProducto);
    }

    @Override
    public VarianteProducto updateVarianteProducto(Long id, VarianteProducto varianteProducto) {
        genericValidator.validateId(id, "variante producto");
        genericValidator.validateExists(varianteProducto, "variante producto");

        varianteProducto.setTalla(varianteProducto.getTalla());
        varianteProducto.setColor(varianteProducto.getColor());
        varianteProducto.setStock_variante(varianteProducto.getStock_variante());

        return varianteProductoRepository.save(varianteProducto);
    }

    @Override
    public void deleteVarianteProducto(Long id) {
        genericValidator.validateId(id, "variante producto");
        genericValidator.validateExists(getVarianteProductoById(id), "variante producto");

        varianteProductoRepository.deleteById(id);
    }
}
