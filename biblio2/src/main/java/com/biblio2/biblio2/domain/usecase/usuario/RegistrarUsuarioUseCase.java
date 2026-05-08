package com.biblio2.biblio2.domain.usecase.usuario;

import com.biblio2.biblio2.domain.entity.Usuario;

/**
 * Caso de uso: Registrar Usuario
 * Define el contrato para registrar un nuevo usuario en el sistema
 */
public interface RegistrarUsuarioUseCase {
    /**
     * Ejecuta el caso de uso de registro de usuario
     * @param nombre Nombre del usuario
     * @param email Email del usuario
     * @param password Contraseña del usuario
     * @return Usuario registrado con ID asignado
     */
    Usuario ejecutar(String nombre, String email, String password);
}

