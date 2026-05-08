package com.biblio2.biblio2.application.service;

import com.biblio2.biblio2.domain.entity.Usuario;
import com.biblio2.biblio2.domain.port.UsuarioRepositoryPort;
import com.biblio2.biblio2.domain.exception.UsuarioNoEncontradoException;
import com.biblio2.biblio2.domain.usecase.usuario.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Servicio de Aplicación: Usuario
 * Orquesta los casos de uso relacionados con usuarios
 * Implementa las interfaces de casos de uso y delega en los puertos
 */
@Service
public class UsuarioApplicationService implements
    RegistrarUsuarioUseCase,
    ObtenerUsuarioPorIdUseCase,
    ActualizarUsuarioUseCase {

    private final UsuarioRepositoryPort usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructor con inyección de dependencias
     * @param usuarioRepository Puerto de persistencia de usuarios
     * @param passwordEncoder Codificador de contraseñas
     */
    public UsuarioApplicationService(UsuarioRepositoryPort usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registra un nuevo usuario en el sistema
     */
    public Usuario registrarUsuario(String nombre, String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Usuario nuevoUsuario = new Usuario(nombre, email, encodedPassword);
        return usuarioRepository.guardar(nuevoUsuario);
    }

    /**
     * Implementación del caso de uso: RegistrarUsuarioUseCase (interfaz)
     */
    @Override
    public Usuario ejecutar(String nombre, String email, String password) {
        return registrarUsuario(nombre, email, password);
    }

    /**
     * Obtiene un usuario por su ID
     */
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.obtenerPorId(id)
            .orElseThrow(() -> new UsuarioNoEncontradoException("Usuario con ID " + id + " no encontrado"));
    }

    /**
     * Implementación del caso de uso: ObtenerUsuarioPorIdUseCase (interfaz)
     * Nota: Este método tiene el mismo nombre que otro ejecutar(Long id),
     * por eso implementamos con método privado.
     */
    @Override
    public Usuario ejecutar(Long id) {
        return obtenerUsuarioPorId(id);
    }

    /**
     * Actualiza los datos de un usuario existente
     */
    public Usuario actualizarUsuario(Long id, String nombre, String email) {
        Usuario usuario = obtenerUsuarioPorId(id);
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        return usuarioRepository.actualizar(usuario);
    }

    /**
     * Implementación del caso de uso: ActualizarUsuarioUseCase (interfaz)
     */
    @Override
    public Usuario ejecutar(Long id, String nombre, String email) {
        return actualizarUsuario(id, nombre, email);
    }

    /**
     * Obtener usuario por email
     * @param email Email del usuario a buscar
     * @return Usuario encontrado
     * @throws UsuarioNoEncontradoException si el usuario no existe
     */
    public Usuario obtenerPorEmail(String email) {
        return usuarioRepository.obtenerPorEmail(email)
            .orElseThrow(() -> new UsuarioNoEncontradoException("Usuario con email " + email + " no encontrado"));
    }
}

