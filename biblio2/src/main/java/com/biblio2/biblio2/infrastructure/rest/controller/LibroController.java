package com.biblio2.biblio2.infrastructure.rest.controller;
import com.biblio2.biblio2.domain.entity.Libro;
import com.biblio2.biblio2.domain.usecase.*;
import com.biblio2.biblio2.infrastructure.rest.dto.LibroRequest;
import com.biblio2.biblio2.infrastructure.rest.dto.LibroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Controlador REST: Punto de entrada para las operaciones con libros
 * Puerto de entrada (Input Port) que adapta HTTP a casos de uso
 */
@RestController
@RequestMapping("/api/libros")
public class LibroController {
    private final CrearLibroUseCase crearLibroUseCase;
    private final ObtenerLibrosUseCase obtenerLibrosUseCase;
    private final ObtenerLibroPorIdUseCase obtenerLibroPorIdUseCase;
    private final EliminarLibroUseCase eliminarLibroUseCase;
    private final ActualizarLibroUseCase actualizarLibroUseCase;
    public LibroController(
            CrearLibroUseCase crearLibroUseCase,
            ObtenerLibrosUseCase obtenerLibrosUseCase,
            ObtenerLibroPorIdUseCase obtenerLibroPorIdUseCase,
            EliminarLibroUseCase eliminarLibroUseCase,
            ActualizarLibroUseCase actualizarLibroUseCase) {
        this.crearLibroUseCase = crearLibroUseCase;
        this.obtenerLibrosUseCase = obtenerLibrosUseCase;
        this.obtenerLibroPorIdUseCase = obtenerLibroPorIdUseCase;
        this.eliminarLibroUseCase = eliminarLibroUseCase;
        this.actualizarLibroUseCase = actualizarLibroUseCase;
    }
    /**
     * POST /api/libros - Crear un nuevo libro
     */
    @PostMapping
    public ResponseEntity<LibroResponse> crearLibro(@RequestBody LibroRequest request) {
        Libro libro = crearLibroUseCase.ejecutar(
            request.getTitulo(),
            request.getAutor(),
            request.getIsbn()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(mapToResponse(libro));
    }
    /**
     * GET /api/libros - Obtener todos los libros
     */
    @GetMapping
    public ResponseEntity<List<LibroResponse>> obtenerTodos() {
        List<Libro> libros = obtenerLibrosUseCase.ejecutar();
        List<LibroResponse> responses = libros.stream()
            .map(this::mapToResponse)
            .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
    /**
     * GET /api/libros/{id} - Obtener un libro por su ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<LibroResponse> obtenerPorId(@PathVariable Long id) {
        Libro libro = obtenerLibroPorIdUseCase.ejecutar(id);
        return ResponseEntity.ok(mapToResponse(libro));
    }
    /**
     * PUT /api/libros/{id} - Actualizar un libro
     */
    @PutMapping("/{id}")
    public ResponseEntity<LibroResponse> actualizarLibro(
            @PathVariable Long id,
            @RequestBody LibroRequest request) {
        Libro libro = actualizarLibroUseCase.ejecutar(
            id,
            request.getTitulo(),
            request.getAutor(),
            request.getIsbn()
        );
        return ResponseEntity.ok(mapToResponse(libro));
    }
    /**
     * DELETE /api/libros/{id} - Eliminar un libro
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        eliminarLibroUseCase.ejecutar(id);
        return ResponseEntity.noContent().build();
    }
    /**
     * Mapea una entidad de dominio a un DTO de respuesta
     */
    private LibroResponse mapToResponse(Libro libro) {
        return new LibroResponse(
            libro.getId(),
            libro.getTitulo(),
            libro.getAutor(),
            libro.getIsbn()
        );
    }
}
