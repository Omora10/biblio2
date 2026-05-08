package com.biblio2.biblio2.domain.usecase.prestamo;

/**
 * Caso de uso: Devolver Préstamo
 * Define el contrato para registrar la devolución de un libro prestado
 */
public interface DevolverPrestamoUseCase {
    /**
     * Ejecuta el caso de uso de devolución de préstamo
     * @param id ID del préstamo a devolver
     * @throws com.biblio2.biblio2.domain.exception.PrestamoNoEncontradoException si el préstamo no existe
     */
    void ejecutar(Long id);
}

