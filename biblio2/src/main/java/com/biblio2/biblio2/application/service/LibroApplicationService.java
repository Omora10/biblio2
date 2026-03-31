package com.biblio2.biblio2.application.service;
import com.biblio2.biblio2.domain.entity.Libro;
import com.biblio2.biblio2.domain.port.LibroRepositoryPort;
import com.biblio2.biblio2.domain.usecase.*;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Servicio de aplicación para la gestión de libros
 * Orquesta la lógica de negocio usando los casos de uso
 * Implementa todos los casos de uso y depende solo del dominio
 */
@Service
public class LibroApplicationService implements 
    CrearLibroUseCase, 
    ObtenerLibrosUseCase, 
    ObtenerLibroPorIdUseCase,
    EliminarLibroUseCase,
    ActualizarLibroUseCase {
    private final LibroRepositoryPort libroRepository;
    /**
     * Inyección de dependencias: el repositorio se inyecta desde infraestructura
     */
    public LibroApplicationService(LibroRepositoryPort libroRepository) {
        this.libroRepository = libroRepository;
    }
    /**
     * Implementación de CrearLibroUseCase
     */
    @Override
    public Libro ejecutar(String titulo, String autor, String isbn) {
        Libro nuevoLibro = new Libro(titulo, autor, isbn);
        return libroRepository.guardar(nuevoLibro);
    }
    /**
     * Implementación de ObtenerLibrosUseCase
     */
    @Override
    public List<Libro> ejecutar() {
        return libroRepository.obtenerTodos();
    }
    /**
     * Implementación de ObtenerLibroPorIdUseCase
     */
    @Override
    public Libro ejecutar(Long id) {
        return libroRepository.obtenerPorId(id)
            .orElseThrow(() -> new LibroNoEncontradoException("Libro con ID " + id + " no encontrado"));
    }
    /**
     * Implementación de EliminarLibroUseCase
     */
    @Override
    public void ejecutar(Long id) {
        if (!libroRepository.existe(id)) {
            throw new LibroNoEncontradoException("Libro con ID " + id + " no encontrado");
        }
        libroRepository.eliminar(id);
    }
    /**
     * Implementación de ActualizarLibroUseCase
     */
    @Override
    public Libro ejecutar(Long id, String titulo, String autor, String isbn) {
        Libro libroExistente = libroRepository.obtenerPorId(id)
            .orElseThrow(() -> new LibroNoEncontradoException("Libro con ID " + id + " no encontrado"));
        libroExistente.setTitulo(titulo);
        libroExistente.setAutor(autor);
        libroExistente.setIsbn(isbn);
        return libroRepository.actualizar(libroExistente);
    }
}
