package com.biblio2.biblio2.infrastructure.persistence.repository;

import com.biblio2.biblio2.infrastructure.persistence.entity.PrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio JPA: Préstamo
 * Proporciona operaciones de persistencia para la entidad Préstamo
 * Extendido por Spring Data JPA que implementa automáticamente CRUD básico
 */
@Repository
public interface PrestamoJpaRepository extends JpaRepository<PrestamoEntity, Long> {

    /**
     * Obtiene todos los préstamos de un usuario
     * @param usuarioId ID del usuario
     * @return Lista de préstamos del usuario
     */
    List<PrestamoEntity> findByUsuarioId(Long usuarioId);
}

