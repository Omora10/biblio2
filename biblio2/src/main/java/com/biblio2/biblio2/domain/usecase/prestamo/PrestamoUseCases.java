package com.biblio2.biblio2.domain.usecase.prestamo;

import com.biblio2.biblio2.domain.entity.Prestamo;
import java.util.List;

/**
 * Interfaz consolidada de casos de uso para Préstamos
 * Evita conflictos de métodos con el mismo nombre pero diferente firma
 */
public interface PrestamoUseCases {
    
    /**
     * Crea un nuevo préstamo para un usuario de un libro específico
     * @param usuarioId ID del usuario que realiza el préstamo
     * @param libroId ID del libro a prestar
     * @return Préstamo creado
     */
    Prestamo crearPrestamo(Long usuarioId, Long libroId);
    
    /**
     * Registra la devolución de un préstamo
     * @param prestamoId ID del préstamo a devolver
     */
    void devolverPrestamo(Long prestamoId);
    
    /**
     * Renueva un préstamo existente extendiendo su fecha de devolución
     * @param prestamoId ID del préstamo a renovar
     * @return Préstamo renovado
     */
    Prestamo renovarPrestamo(Long prestamoId);
    
    /**
     * Lista todos los préstamos de un usuario específico
     * @param usuarioId ID del usuario cuyos préstamos se desean listar
     * @return Lista de préstamos del usuario
     */
    List<Prestamo> listarPorUsuario(Long usuarioId);
}

