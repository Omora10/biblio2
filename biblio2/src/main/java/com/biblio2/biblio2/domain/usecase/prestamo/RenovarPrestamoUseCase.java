package com.biblio2.biblio2.domain.usecase.prestamo;

import com.biblio2.biblio2.domain.entity.Prestamo;

/**
 * Caso de uso: Renovar Préstamo
 * Define el contrato para renovar la fecha de devolución de un préstamo existente
 */
public interface RenovarPrestamoUseCase {
    /**
     * Ejecuta el caso de uso de renovación de préstamo
     * @param id ID del préstamo a renovar
     * @return Préstamo renovado con nueva fecha de devolución
     * @throws com.biblio2.biblio2.domain.exception.PrestamoNoEncontradoException si el préstamo no existe
     */
    Prestamo ejecutar(Long id);
}

