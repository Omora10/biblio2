package com.biblio2.biblio2.domain.usecase.usuario;

import com.biblio2.biblio2.domain.entity.Usuario;

/**
 * Caso de uso: Actualizar Usuario
 * Define el contrato para actualizar los datos de un usuario existente
 */
public interface ActualizarUsuarioUseCase {
    /**
     * Ejecuta el caso de uso de actualización de usuario
     * @param id ID del usuario a actualizar
     * @param nombre Nuevo nombre del usuario
     * @param email Nuevo email del usuario
     * @return Usuario actualizado
     * @throws com.biblio2.biblio2.domain.exception.UsuarioNoEncontradoException si el usuario no existe
     */
    Usuario ejecutar(Long id, String nombre, String email);
}

