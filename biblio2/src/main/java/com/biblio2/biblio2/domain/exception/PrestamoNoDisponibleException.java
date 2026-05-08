package com.biblio2.biblio2.domain.exception;

/**
 * Excepción de dominio: Préstamo no disponible
 * Se lanza cuando se intenta hacer un préstamo pero el libro no está disponible
 */
public class PrestamoNoDisponibleException extends RuntimeException {
    public PrestamoNoDisponibleException(String message) {
        super(message);
    }

    public PrestamoNoDisponibleException(String message, Throwable cause) {
        super(message, cause);
    }
}

