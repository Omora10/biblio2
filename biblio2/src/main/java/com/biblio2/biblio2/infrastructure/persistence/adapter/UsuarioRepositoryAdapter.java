package com.biblio2.biblio2.infrastructure.persistence.adapter;

import com.biblio2.biblio2.domain.entity.Usuario;
import com.biblio2.biblio2.domain.port.UsuarioRepositoryPort;
import com.biblio2.biblio2.infrastructure.persistence.entity.UsuarioEntity;
import com.biblio2.biblio2.infrastructure.persistence.repository.UsuarioJpaRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
 * Adaptador de Repositorio: Usuario
 * Implementa el puerto UsuarioRepositoryPort
 * Adapta la interfaz JPA a la interfaz de dominio (inversión de dependencias)
 */
@Component
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository jpaRepository;

    /**
     * Constructor con inyección de dependencias
     * @param jpaRepository Repositorio JPA de usuarios
     */
    public UsuarioRepositoryAdapter(UsuarioJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    /**
     * Guarda un nuevo usuario o actualiza uno existente
     */
    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntity entity = mapToEntity(usuario);
        entity = jpaRepository.save(entity);
        return mapToDomain(entity);
    }

    /**
     * Obtiene un usuario por su ID
     */
    @Override
    public Optional<Usuario> obtenerPorId(Long id) {
        return jpaRepository.findById(id).map(this::mapToDomain);
    }

    /**
     * Obtiene un usuario por su email
     */
    @Override
    public Optional<Usuario> obtenerPorEmail(String email) {
        return jpaRepository.findByEmail(email).map(this::mapToDomain);
    }

    /**
     * Actualiza un usuario existente
     */
    @Override
    public Usuario actualizar(Usuario usuario) {
        return guardar(usuario);
    }

    /**
     * Elimina un usuario por su ID
     */
    @Override
    public void eliminar(Long id) {
        jpaRepository.deleteById(id);
    }

    /**
     * Verifica si un usuario existe
     */
    @Override
    public boolean existe(Long id) {
        return jpaRepository.existsById(id);
    }

    /**
     * Mapea una entidad de dominio a entidad JPA
     */
    private UsuarioEntity mapToEntity(Usuario usuario) {
        UsuarioEntity entity = new UsuarioEntity();
        if (usuario.getId() != null) {
            entity.setId(usuario.getId());
        }
        entity.setNombre(usuario.getNombre());
        entity.setEmail(usuario.getEmail());
        entity.setPassword(usuario.getPassword());
        return entity;
    }

    /**
     * Mapea una entidad JPA a entidad de dominio
     */
    private Usuario mapToDomain(UsuarioEntity entity) {
        Usuario usuario = new Usuario(entity.getNombre(), entity.getEmail(), entity.getPassword());
        usuario.setId(entity.getId());
        return usuario;
    }
}

