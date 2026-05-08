package com.biblio2.biblio2.infrastructure.persistence.repository;

import com.biblio2.biblio2.infrastructure.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repositorio JPA: Usuario
 * Proporciona operaciones de persistencia para la entidad Usuario
 * Extendido por Spring Data JPA que implementa automáticamente CRUD básico
 */
@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {

    /**
     * Busca un usuario por su email
     * @param email Email del usuario a buscar
     * @return Optional con el usuario si existe
     */
    Optional<UsuarioEntity> findByEmail(String email);
}

