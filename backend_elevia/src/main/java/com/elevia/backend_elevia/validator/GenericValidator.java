package com.elevia.backend_elevia.validator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class GenericValidator {

    public void validateId(Long id, String entityName) {
        if (id == null) {
            throw new IllegalArgumentException("El Id de " + entityName + " es requerido");
        }
    }

    public <T> T validateEntityExists(Long id, String entityName, JpaRepository<T, Long> repository) {
        validateId(id, entityName); // Validate the ID first
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(entityName + " no encontrado con Id: " + id));
    }

}