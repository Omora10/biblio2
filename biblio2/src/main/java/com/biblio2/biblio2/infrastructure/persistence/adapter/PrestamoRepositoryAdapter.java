package com.biblio2.biblio2.infrastructure.persistence.adapter;

import com.biblio2.biblio2.domain.entity.Prestamo;
import com.biblio2.biblio2.domain.entity.Usuario;
import com.biblio2.biblio2.domain.entity.Libro;
import com.biblio2.biblio2.domain.port.PrestamoRepositoryPort;
import com.biblio2.biblio2.infrastructure.persistence.entity.PrestamoEntity;
import com.biblio2.biblio2.infrastructure.persistence.entity.UsuarioEntity;
import com.biblio2.biblio2.infrastructure.persistence.entity.LibroEntity;
import com.biblio2.biblio2.infrastructure.persistence.repository.PrestamoJpaRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Adaptador de Repositorio: Préstamo
 * Implementa el puerto PrestamoRepositoryPort
 * Adapta la interfaz JPA a la interfaz de dominio (inversión de dependencias)
 */
@Component
public class PrestamoRepositoryAdapter implements PrestamoRepositoryPort {

    private final PrestamoJpaRepository jpaRepository;

    /**
     * Constructor con inyección de dependencias
     * @param jpaRepository Repositorio JPA de préstamos
     */
    public PrestamoRepositoryAdapter(PrestamoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    /**
     * Guarda un nuevo préstamo o actualiza uno existente
     */
    @Override
    public Prestamo guardar(Prestamo prestamo) {
        PrestamoEntity entity = mapToEntity(prestamo);
        entity = jpaRepository.save(entity);
        return mapToDomain(entity);
    }

    /**
     * Obtiene un préstamo por su ID
     */
    @Override
    public Optional<Prestamo> obtenerPorId(Long id) {
        return jpaRepository.findById(id).map(this::mapToDomain);
    }

    /**
     * Obtiene todos los préstamos de un usuario
     */
    @Override
    public List<Prestamo> obtenerPorUsuario(Long usuarioId) {
        return jpaRepository.findByUsuarioId(usuarioId).stream()
            .map(this::mapToDomain)
            .collect(Collectors.toList());
    }

    /**
     * Actualiza un préstamo existente
     */
    @Override
    public Prestamo actualizar(Prestamo prestamo) {
        return guardar(prestamo);
    }

    /**
     * Elimina un préstamo por su ID
     */
    @Override
    public void eliminar(Long id) {
        jpaRepository.deleteById(id);
    }

    /**
     * Mapea una entidad de dominio a entidad JPA
     */
    private PrestamoEntity mapToEntity(Prestamo prestamo) {
        PrestamoEntity entity = new PrestamoEntity();
        if (prestamo.getId() != null) {
            entity.setId(prestamo.getId());
        }

        // Mapear usuario
        if (prestamo.getUsuario() != null) {
            UsuarioEntity usuarioEntity = new UsuarioEntity();
            usuarioEntity.setId(prestamo.getUsuario().getId());
            usuarioEntity.setNombre(prestamo.getUsuario().getNombre());
            usuarioEntity.setEmail(prestamo.getUsuario().getEmail());
            usuarioEntity.setPassword(prestamo.getUsuario().getPassword());
            entity.setUsuario(usuarioEntity);
        }

        // Mapear libro
        if (prestamo.getLibro() != null) {
            LibroEntity libroEntity = new LibroEntity();
            libroEntity.setId(prestamo.getLibro().getId());
            libroEntity.setTitulo(prestamo.getLibro().getTitulo());
            libroEntity.setAutor(prestamo.getLibro().getAutor());
            libroEntity.setIsbn(prestamo.getLibro().getIsbn());
            libroEntity.setPrestado(prestamo.getLibro().isPrestado());
            entity.setLibro(libroEntity);
        }

        entity.setFechaPrestamo(prestamo.getFechaPrestamo());
        entity.setFechaDevolucion(prestamo.getFechaDevolucion());
        entity.setDevuelto(prestamo.isDevuelto());
        return entity;
    }

    /**
     * Mapea una entidad JPA a entidad de dominio
     */
    private Prestamo mapToDomain(PrestamoEntity entity) {
        // Mapear usuario
        Usuario usuario = null;
        if (entity.getUsuario() != null) {
            usuario = new Usuario(
                entity.getUsuario().getId(),
                entity.getUsuario().getNombre(),
                entity.getUsuario().getEmail(),
                entity.getUsuario().getPassword()
            );
        }

        // Mapear libro
        Libro libro = null;
        if (entity.getLibro() != null) {
            libro = new Libro(
                entity.getLibro().getId(),
                entity.getLibro().getTitulo(),
                entity.getLibro().getAutor(),
                entity.getLibro().getIsbn()
            );
            libro.setPrestado(entity.getLibro().isPrestado());
        }

        Prestamo prestamo = new Prestamo(usuario, libro, entity.getFechaPrestamo());
        prestamo.setId(entity.getId());
        prestamo.setFechaDevolucion(entity.getFechaDevolucion());
        prestamo.setDevuelto(entity.isDevuelto());
        return prestamo;
    }
}

