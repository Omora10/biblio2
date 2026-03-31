package com.biblio2.biblio2.domain.port;
import com.biblio2.biblio2.domain.entity.Libro;
import java.util.List;
import java.util.Optional;
/**
 * Puerto de salida: Define el contrato para persistencia
 * Sin dependencias de Spring. Puramente de dominio.
 */
public interface LibroRepositoryPort {
    Libro guardar(Libro libro);
    Optional<Libro> obtenerPorId(Long id);
    List<Libro> obtenerTodos();
    void eliminar(Long id);
    boolean existe(Long id);
    Libro actualizar(Libro libro);
}
