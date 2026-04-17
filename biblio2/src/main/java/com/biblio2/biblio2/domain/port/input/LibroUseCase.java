package com.biblio2.biblio2.domain.port.input;

import com.biblio2.biblio2.application.dto.LibroCommand;
import com.biblio2.biblio2.application.dto.LibroDto;
import java.util.List;

/**
 * Puerto de entrada (Input Port) compuesto para la gestión de libros.
 * Define el contrato que la capa de aplicación expone hacia infraestructura.
 * Trabaja con DTOs de aplicación para no mezclar capas.
 */
public interface LibroUseCase {

    /** Caso de uso: Crear un nuevo libro. */
    LibroDto crear(LibroCommand command);

    /** Caso de uso: Obtener todos los libros. */
    List<LibroDto> obtenerTodos();

    /** Caso de uso: Obtener un libro por su ID. */
    LibroDto obtenerPorId(Long id);

    /** Caso de uso: Eliminar un libro por su ID. */
    void eliminar(Long id);

    /** Caso de uso: Actualizar un libro existente. */
    LibroDto actualizar(Long id, LibroCommand command);
}
