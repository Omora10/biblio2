package com.biblio2.biblio2.application.service;

import com.biblio2.biblio2.application.dto.LibroCommand;
import com.biblio2.biblio2.application.dto.LibroDto;
import com.biblio2.biblio2.domain.entity.Libro;
import com.biblio2.biblio2.domain.exception.LibroNoEncontradoException;
import com.biblio2.biblio2.domain.port.input.LibroUseCase;
import com.biblio2.biblio2.domain.port.output.LibroRepositoryPort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio de aplicación para la gestión de libros.
 * Implementa el puerto de entrada LibroUseCase.
 * Orquesta la lógica de negocio mapeando entre DTOs de aplicación y entidades de dominio.
 */
@Service
public class LibroApplicationService implements LibroUseCase {

    private final LibroRepositoryPort libroRepository;

    public LibroApplicationService(LibroRepositoryPort libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public LibroDto crear(LibroCommand command) {
        Libro nuevoLibro = new Libro(command.getTitulo(), command.getAutor(), command.getIsbn());
        return mapToDto(libroRepository.guardar(nuevoLibro));
    }

    @Override
    public List<LibroDto> obtenerTodos() {
        return libroRepository.obtenerTodos().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public LibroDto obtenerPorId(Long id) {
        return libroRepository.obtenerPorId(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new LibroNoEncontradoException("Libro con ID " + id + " no encontrado"));
    }

    @Override
    public void eliminar(Long id) {
        if (!libroRepository.existe(id)) {
            throw new LibroNoEncontradoException("Libro con ID " + id + " no encontrado");
        }
        libroRepository.eliminar(id);
    }

    @Override
    public LibroDto actualizar(Long id, LibroCommand command) {
        Libro libroExistente = libroRepository.obtenerPorId(id)
                .orElseThrow(() -> new LibroNoEncontradoException("Libro con ID " + id + " no encontrado"));
        libroExistente.setTitulo(command.getTitulo());
        libroExistente.setAutor(command.getAutor());
        libroExistente.setIsbn(command.getIsbn());
        return mapToDto(libroRepository.actualizar(libroExistente));
    }

    // ── Mapper interno: dominio → DTO de aplicación ─────────────────────────
    private LibroDto mapToDto(Libro libro) {
        return new LibroDto(libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getIsbn());
    }
}
