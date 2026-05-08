package com.biblio2.biblio2.application.exception;

/**
 * Excepción de aplicación: Préstamo no disponible
 * Se lanza desde la capa de aplicación cuando hay problemas con la disponibilidad de un préstamo
 * Mapea la excepción de dominio a la capa de aplicación
 */
public class PrestamoNoDisponibleException extends RuntimeException {
    public PrestamoNoDisponibleException(String message) {
        super(message);
    }

    public PrestamoNoDisponibleException(String message, Throwable cause) {
        super(message, cause);
    }
}

