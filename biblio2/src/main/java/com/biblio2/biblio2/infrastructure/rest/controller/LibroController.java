package com.biblio2.biblio2.infrastructure.rest.controller;

import com.biblio2.biblio2.application.dto.LibroCommand;
import com.biblio2.biblio2.application.dto.LibroDto;
import com.biblio2.biblio2.domain.port.input.LibroUseCase;
import com.biblio2.biblio2.infrastructure.rest.dto.LibroRequest;
import com.biblio2.biblio2.infrastructure.rest.dto.LibroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Adaptador de entrada REST.
 * Traduce HTTP (LibroRequest/LibroResponse) ↔ DTOs de aplicación (LibroCommand/LibroDto).
 * No conoce ni el dominio ni la persistencia.
 */
@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroUseCase libroUseCase;

    public LibroController(LibroUseCase libroUseCase) {
        this.libroUseCase = libroUseCase;
    }

    /** POST /api/libros - Crear un nuevo libro */
    @PostMapping
    public ResponseEntity<LibroResponse> crearLibro(@RequestBody LibroRequest request) {
        LibroDto dto = libroUseCase.crear(toCommand(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(dto));
    }

    /** GET /api/libros - Obtener todos los libros */
    @GetMapping
    public ResponseEntity<List<LibroResponse>> obtenerTodos() {
        List<LibroResponse> responses = libroUseCase.obtenerTodos().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    /** GET /api/libros/{id} - Obtener un libro por su ID */
    @GetMapping("/{id}")
    public ResponseEntity<LibroResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(toResponse(libroUseCase.obtenerPorId(id)));
    }

    /** PUT /api/libros/{id} - Actualizar un libro */
    @PutMapping("/{id}")
    public ResponseEntity<LibroResponse> actualizarLibro(@PathVariable Long id,
                                                          @RequestBody LibroRequest request) {
        LibroDto dto = libroUseCase.actualizar(id, toCommand(request));
        return ResponseEntity.ok(toResponse(dto));
    }

    /** DELETE /api/libros/{id} - Eliminar un libro */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // ── Mappers: infraestructura ↔ aplicación ───────────────────────────────
    private LibroCommand toCommand(LibroRequest request) {
        return new LibroCommand(request.getTitulo(), request.getAutor(), request.getIsbn());
    }

    private LibroResponse toResponse(LibroDto dto) {
        return new LibroResponse(dto.getId(), dto.getTitulo(), dto.getAutor(), dto.getIsbn());
    }
}
