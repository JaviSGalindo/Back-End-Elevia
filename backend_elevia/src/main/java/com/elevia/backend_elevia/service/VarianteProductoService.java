package com.elevia.backend_elevia.service;

import com.elevia.backend_elevia.model.VarianteProducto;
import com.elevia.backend_elevia.repository.IvarianteProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VarianteProductoService implements IvarianteProductoService {

    private final IvarianteProductoRepository varianteProductoRepository;


    @Autowired
    public VarianteProductoService(IvarianteProductoRepository varianteProductoRepository) {
        this.varianteProductoRepository = varianteProductoRepository;
    }

    @Override
    public List<VarianteProducto> getAllVarianteProducto() {
        return varianteProductoRepository.findAll();
    }

    @Override
    public VarianteProducto getVarianteProductoById(Long id) {
        validateVarianteProductoId(id);

        VarianteProducto varianteProducto = varianteProductoRepository.findById(id).orElse(null);

        validateVarianteProductoExists(varianteProducto);

        return varianteProducto;
    }

    @Override
    public VarianteProducto createVarianteProducto(VarianteProducto varianteProducto) {

        validateVarianteProductoExists(varianteProducto);

        return varianteProductoRepository.save(varianteProducto);
    }

    @Override
    public VarianteProducto updateVarianteProducto(Long id, VarianteProducto varianteProducto) {
        validateVarianteProductoId(id);
        validateVarianteProductoExists(varianteProducto);

        varianteProducto.setTalla(varianteProducto.getTalla());
        varianteProducto.setColor(varianteProducto.getColor());
        varianteProducto.setStock_variante(varianteProducto.getStock_variante());

        return varianteProductoRepository.save(varianteProducto);
    }

    @Override
    public void deleteVarianteProducto(Long id) {
        validateVarianteProductoId(id);
        validateVarianteProductoExists(getVarianteProductoById(id));

        varianteProductoRepository.deleteById(id);

    }

    //Valida si se pasa un id
    private void validateVarianteProductoId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El id de la variante de producto es requerido");
        }
    }

    //Valida si existe una variante de producto
    private void validateVarianteProductoExists(VarianteProducto varianteProducto) {
        if (varianteProducto == null) {
            throw new IllegalArgumentException("La variante de producto no existe");
        }
    }
}
