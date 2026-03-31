package com.biblio2.biblio2.domain.usecase;
import com.biblio2.biblio2.domain.entity.Libro;
import java.util.List;
/**
 * Caso de uso: Obtener todos los libros
 */
public interface ObtenerLibrosUseCase {
    List<Libro> ejecutar();
}
