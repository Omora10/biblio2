package com.biblio2.biblio2.application.exception;
/**
 * Excepción de aplicación: Libro no encontrado
 */
public class LibroNoEncontradoException extends RuntimeException {
    public LibroNoEncontradoException(String mensaje) {
        super(mensaje);
    }
    public LibroNoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
