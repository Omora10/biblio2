package com.biblio2.biblio2.domain.exception;

/**
 * Excepción de dominio: Usuario no encontrado
 * Se lanza cuando se intenta acceder a un usuario que no existe
 */
public class UsuarioNoEncontradoException extends RuntimeException {
    public UsuarioNoEncontradoException(String message) {
        super(message);
    }

    public UsuarioNoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}

