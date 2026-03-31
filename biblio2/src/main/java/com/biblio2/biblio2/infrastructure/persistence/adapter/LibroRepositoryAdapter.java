package com.biblio2.biblio2.infrastructure.persistence.adapter;
import com.biblio2.biblio2.domain.entity.Libro;
import com.biblio2.biblio2.domain.port.LibroRepositoryPort;
import com.biblio2.biblio2.infrastructure.persistence.entity.LibroEntity;
import com.biblio2.biblio2.infrastructure.persistence.repository.LibroJpaRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Adaptador: Implementa el puerto LibroRepositoryPort
 * Conecta el dominio con la infraestructura JPA
 * Traduce entre entidades de dominio y entidades JPA
 */
@Component
public class LibroRepositoryAdapter implements LibroRepositoryPort {
    private final LibroJpaRepository jpaRepository;
    public LibroRepositoryAdapter(LibroJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    @Override
    public Libro guardar(Libro libro) {
        LibroEntity entity = new LibroEntity(
            libro.getTitulo(),
            libro.getAutor(),
            libro.getIsbn()
        );
        LibroEntity savedEntity = jpaRepository.save(entity);
        return mapToDomain(savedEntity);
    }
    @Override
    public Optional<Libro> obtenerPorId(Long id) {
        return jpaRepository.findById(id)
            .map(this::mapToDomain);
    }
    @Override
    public List<Libro> obtenerTodos() {
        return jpaRepository.findAll()
            .stream()
            .map(this::mapToDomain)
            .collect(Collectors.toList());
    }
    @Override
    public void eliminar(Long id) {
        jpaRepository.deleteById(id);
    }
    @Override
    public boolean existe(Long id) {
        return jpaRepository.existsById(id);
    }
    @Override
    public Libro actualizar(Libro libro) {
        LibroEntity entity = new LibroEntity(
            libro.getId(),
            libro.getTitulo(),
            libro.getAutor(),
            libro.getIsbn()
        );
        LibroEntity updatedEntity = jpaRepository.save(entity);
        return mapToDomain(updatedEntity);
    }
    /**
     * Mapea una entidad JPA a una entidad de dominio
     */
    private Libro mapToDomain(LibroEntity entity) {
        return new Libro(
            entity.getId(),
            entity.getTitulo(),
            entity.getAutor(),
            entity.getIsbn()
        );
    }
}
