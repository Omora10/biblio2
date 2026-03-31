package com.biblio2.biblio2.infrastructure.persistence.repository;
import com.biblio2.biblio2.infrastructure.persistence.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Repositorio JPA para LibroEntity
 * Spring Data proporciona las operaciones CRUD automáticamente
 */
@Repository
public interface LibroJpaRepository extends JpaRepository<LibroEntity, Long> {
}
