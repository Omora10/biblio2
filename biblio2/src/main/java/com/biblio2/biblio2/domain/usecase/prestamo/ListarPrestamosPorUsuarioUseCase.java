package com.biblio2.biblio2.domain.usecase.prestamo;

import com.biblio2.biblio2.domain.entity.Prestamo;
import java.util.List;

/**
 * Caso de uso: Listar Préstamos por Usuario
 * Define el contrato para obtener todos los préstamos de un usuario
 */
public interface ListarPrestamosPorUsuarioUseCase {
    /**
     * Ejecuta el caso de uso de listado de préstamos
     * @param usuarioId ID del usuario cuyos préstamos se desean listar
     * @return Lista de préstamos del usuario
     */
    List<Prestamo> ejecutar(Long usuarioId);
}

