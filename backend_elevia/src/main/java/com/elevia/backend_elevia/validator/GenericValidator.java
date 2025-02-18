package com.elevia.backend_elevia.validator;

import org.springframework.stereotype.Component;

@Component
public class GenericValidator {

    public void validateId(Long id, String entityName) {
        if (id == null) {
            throw new IllegalArgumentException("El Id de " + entityName + " es requerido");
        }
    }

    public <T> void validateExists(T object, String entityName) {
        if (object == null) {
            throw new IllegalArgumentException(entityName + " no existe");
        }
    }
}