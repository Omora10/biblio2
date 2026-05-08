package com.biblio2.biblio2.domain.usecase.prestamo;

import com.biblio2.biblio2.domain.entity.Prestamo;

/**
 * Caso de uso: Crear Préstamo
 * Define el contrato para crear un nuevo préstamo de libro
 */
public interface CrearPrestamoUseCase {
    /**
     * Ejecuta el caso de uso de creación de préstamo
     * @param usuarioId ID del usuario que realiza el préstamo
     * @param libroId ID del libro a prestar
     * @return Préstamo creado
     * @throws com.biblio2.biblio2.domain.exception.UsuarioNoEncontradoException si el usuario no existe
     * @throws com.biblio2.biblio2.domain.exception.LibroNoEncontradoException si el libro no existe
     * @throws com.biblio2.biblio2.domain.exception.PrestamoNoDisponibleException si el libro no está disponible
     */
    Prestamo ejecutar(Long usuarioId, Long libroId);
}

