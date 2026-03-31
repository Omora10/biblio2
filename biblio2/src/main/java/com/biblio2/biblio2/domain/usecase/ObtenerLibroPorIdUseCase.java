package com.biblio2.biblio2.domain.usecase;
import com.biblio2.biblio2.domain.entity.Libro;
/**
 * Caso de uso: Obtener un libro por su ID
 */
public interface ObtenerLibroPorIdUseCase {
    Libro ejecutar(Long id);
}
