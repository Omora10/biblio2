package com.biblio2.biblio2.infrastructure.rest.controller;

import com.biblio2.biblio2.application.dto.PrestamoRequest;
import com.biblio2.biblio2.application.dto.PrestamoResponse;
import com.biblio2.biblio2.application.service.PrestamoApplicationService;
import com.biblio2.biblio2.domain.entity.Prestamo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST: Préstamo
 * Expone los endpoints para la gestión de préstamos
 */
@RestController
@RequestMapping("/api/prestamos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PrestamoController {

    private final PrestamoApplicationService prestamoService;

    /**
     * Constructor con inyección de dependencias
     * @param prestamoService Servicio de aplicación de préstamos
     */
    public PrestamoController(PrestamoApplicationService prestamoService) {
        this.prestamoService = prestamoService;
    }

    /**
     * POST /api/prestamos
     * Crea un nuevo préstamo
     * @param request Datos del préstamo a crear
     * @return Préstamo creado
     */
    @PostMapping
    public ResponseEntity<PrestamoResponse> crear(@RequestBody PrestamoRequest request) {
        Prestamo prestamo = prestamoService.crearPrestamo(request.getUsuarioId(), request.getLibroId());
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(prestamo));
    }

    /**
     * PUT /api/prestamos/{id}/devolver
     * Registra la devolución de un préstamo
     * @param id ID del préstamo a devolver
     * @return Respuesta sin contenido
     */
    @PutMapping("/{id}/devolver")
    public ResponseEntity<Void> devolver(@PathVariable Long id) {
        prestamoService.devolverPrestamo(id);
        return ResponseEntity.ok().build();
    }

    /**
     * PUT /api/prestamos/{id}/renovar
     * Renueva un préstamo existente
     * @param id ID del préstamo a renovar
     * @return Préstamo renovado
     */
    @PutMapping("/{id}/renovar")
    public ResponseEntity<PrestamoResponse> renovar(@PathVariable Long id) {
        Prestamo prestamo = prestamoService.renovarPrestamo(id);
        return ResponseEntity.ok(toResponse(prestamo));
    }

    /**
     * GET /api/prestamos/usuario/{usuarioId}
     * Obtiene todos los préstamos de un usuario
     * @param usuarioId ID del usuario
     * @return Lista de préstamos del usuario
     */
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<PrestamoResponse>> listarPorUsuario(@PathVariable Long usuarioId) {
        List<Prestamo> prestamos = prestamoService.listarPorUsuario(usuarioId);
        List<PrestamoResponse> responses = prestamos.stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    /**
     * Convierte una entidad de dominio Prestamo a DTO PrestamoResponse
     */
    private PrestamoResponse toResponse(Prestamo prestamo) {
        return new PrestamoResponse(
            prestamo.getId(),
            prestamo.getUsuario() != null ? prestamo.getUsuario().getId() : null,
            prestamo.getLibro() != null ? prestamo.getLibro().getId() : null,
            prestamo.getFechaPrestamo(),
            prestamo.getFechaDevolucion(),
            prestamo.isDevuelto()
        );
    }
}


