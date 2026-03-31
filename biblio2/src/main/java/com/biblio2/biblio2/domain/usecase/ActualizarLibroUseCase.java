package com.biblio2.biblio2.domain.usecase;
import com.biblio2.biblio2.domain.entity.Libro;
/**
 * Caso de uso: Actualizar un libro existente
 */
public interface ActualizarLibroUseCase {
    Libro ejecutar(Long id, String titulo, String autor, String isbn);
}
