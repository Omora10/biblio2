package com.biblio2.biblio2.infrastructure.rest.exception;

import com.biblio2.biblio2.domain.exception.LibroNoEncontradoException;
import com.biblio2.biblio2.domain.exception.UsuarioNoEncontradoException;
import com.biblio2.biblio2.domain.exception.PrestamoNoDisponibleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Manejador global de excepciones para la capa REST
 * Convierte excepciones de la aplicación en respuestas HTTP apropiadas
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja LibroNoEncontradoException
     */
    @ExceptionHandler(LibroNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleLibroNoEncontradoException(
            LibroNoEncontradoException ex) {
        return buildErrorResponse("Libro no encontrado", ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Maneja UsuarioNoEncontradoException
     */
    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleUsuarioNoEncontradoException(
            UsuarioNoEncontradoException ex) {
        return buildErrorResponse("Usuario no encontrado", ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Maneja PrestamoNoDisponibleException (capa de aplicación)
     */
    @ExceptionHandler(PrestamoNoDisponibleException.class)
    public ResponseEntity<Map<String, Object>> handlePrestamoNoDisponibleException(
            PrestamoNoDisponibleException ex) {
        return buildErrorResponse("Préstamo no disponible", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Maneja excepciones generales
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        return buildErrorResponse("Error interno del servidor", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Construye una respuesta de error estándar
     */
    private ResponseEntity<Map<String, Object>> buildErrorResponse(String error, String message, HttpStatus status) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", error);
        body.put("message", message);
        return new ResponseEntity<>(body, status);
    }
}




