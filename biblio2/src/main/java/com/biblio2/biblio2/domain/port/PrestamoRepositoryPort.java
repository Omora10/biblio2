package com.biblio2.biblio2.domain.port;

import com.biblio2.biblio2.domain.entity.Prestamo;
import java.util.Optional;
import java.util.List;

/**
 * Puerto (interfaz) de repositorio para Préstamo
 * Define las operaciones de persistencia que debe implementar la capa de infraestructura
 */
public interface PrestamoRepositoryPort {

    /**
     * Guarda un nuevo préstamo en la persistencia
     */
    Prestamo guardar(Prestamo prestamo);

    /**
     * Obtiene un préstamo por su ID
     */
    Optional<Prestamo> obtenerPorId(Long id);

    /**
     * Obtiene todos los préstamos de un usuario
     */
    List<Prestamo> obtenerPorUsuario(Long usuarioId);

    /**
     * Actualiza un préstamo existente
     */
    Prestamo actualizar(Prestamo prestamo);

    /**
     * Elimina un préstamo por su ID
     */
    void eliminar(Long id);
}

