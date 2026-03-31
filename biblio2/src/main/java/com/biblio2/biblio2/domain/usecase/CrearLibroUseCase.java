package com.biblio2.biblio2.domain.usecase;
import com.biblio2.biblio2.domain.entity.Libro;
/**
 * Caso de uso: Crear un nuevo libro
 * Define el contrato sin dependencias de infraestructura
 */
public interface CrearLibroUseCase {
    Libro ejecutar(String titulo, String autor, String isbn);
}
