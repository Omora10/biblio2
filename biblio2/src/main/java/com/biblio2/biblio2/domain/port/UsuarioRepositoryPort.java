package com.biblio2.biblio2.domain.port;

import com.biblio2.biblio2.domain.entity.Usuario;
import java.util.Optional;

/**
 * Puerto (interfaz) de repositorio para Usuario
 * Define las operaciones de persistencia que debe implementar la capa de infraestructura
 */
public interface UsuarioRepositoryPort {

    /**
     * Guarda un nuevo usuario en la persistencia
     */
    Usuario guardar(Usuario usuario);

    /**
     * Obtiene un usuario por su ID
     */
    Optional<Usuario> obtenerPorId(Long id);

    /**
     * Obtiene un usuario por su email
     */
    Optional<Usuario> obtenerPorEmail(String email);

    /**
     * Actualiza un usuario existente
     */
    Usuario actualizar(Usuario usuario);

    /**
     * Elimina un usuario por su ID
     */
    void eliminar(Long id);

    /**
     * Verifica si un usuario existe
     */
    boolean existe(Long id);
}

