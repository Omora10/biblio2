package com.biblio2.biblio2.application.exception;

/**
 * Excepción de aplicación: Usuario no encontrado
 * Se lanza desde la capa de aplicación cuando no se encuentra un usuario
 * Mapea la excepción de dominio a la capa de aplicación
 */
public class UsuarioNoEncontradoException extends RuntimeException {
    public UsuarioNoEncontradoException(String message) {
        super(message);
    }

    public UsuarioNoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}

