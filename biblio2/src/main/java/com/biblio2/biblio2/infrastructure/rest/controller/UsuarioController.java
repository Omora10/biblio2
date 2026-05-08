package com.biblio2.biblio2.infrastructure.rest.controller;

import com.biblio2.biblio2.application.dto.UsuarioRequest;
import com.biblio2.biblio2.application.dto.UsuarioResponse;
import com.biblio2.biblio2.application.service.UsuarioApplicationService;
import com.biblio2.biblio2.domain.entity.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST: Usuario
 * Expone los endpoints para la gestión de usuarios
 */
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UsuarioController {

    private final UsuarioApplicationService usuarioService;

    /**
     * Constructor con inyección de dependencias
     * @param usuarioService Servicio de aplicación de usuarios
     */
    public UsuarioController(UsuarioApplicationService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * POST /api/usuarios/registrar
     * Registra un nuevo usuario en el sistema
     * @param request Datos del usuario a registrar
     * @return Usuario registrado
     */
    @PostMapping("/registrar")
    public ResponseEntity<UsuarioResponse> registrar(@RequestBody UsuarioRequest request) {
        Usuario usuario = usuarioService.registrarUsuario(request.getNombre(), request.getEmail(), request.getPassword());
        UsuarioResponse response = toResponse(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * GET /api/usuarios/{id}
     * Obtiene un usuario por su ID
     * @param id ID del usuario a obtener
     * @return Usuario encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> obtenerPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        return ResponseEntity.ok(toResponse(usuario));
    }

    /**
     * PUT /api/usuarios/{id}
     * Actualiza los datos de un usuario existente
     * @param id ID del usuario a actualizar
     * @param request Nuevos datos del usuario
     * @return Usuario actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> actualizar(@PathVariable Long id, @RequestBody UsuarioRequest request) {
        Usuario usuario = usuarioService.actualizarUsuario(id, request.getNombre(), request.getEmail());
        return ResponseEntity.ok(toResponse(usuario));
    }

    /**
     * GET /api/usuarios/email/{email}
     * Obtiene un usuario por su email
     * @param email Email del usuario a obtener
     * @return Usuario encontrado
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioResponse> obtenerPorEmail(@PathVariable String email) {
        Usuario usuario = usuarioService.obtenerPorEmail(email);
        return ResponseEntity.ok(toResponse(usuario));
    }

    /**
     * Convierte una entidad de dominio Usuario a DTO UsuarioResponse
     */
    private UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(usuario.getId(), usuario.getNombre(), usuario.getEmail());
    }
}


