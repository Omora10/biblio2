package com.biblio2.biblio2.domain.usecase.usuario;

import com.biblio2.biblio2.domain.entity.Usuario;

/**
 * Caso de uso: Obtener Usuario por ID
 * Define el contrato para obtener un usuario existente
 */
public interface ObtenerUsuarioPorIdUseCase {
    /**
     * Ejecuta el caso de uso de obtención de usuario
     * @param id ID del usuario a obtener
     * @return Usuario encontrado
     * @throws com.biblio2.biblio2.domain.exception.UsuarioNoEncontradoException si el usuario no existe
     */
    Usuario ejecutar(Long id);
}

