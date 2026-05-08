package com.biblio2.biblio2.application.service;

import com.biblio2.biblio2.domain.entity.Prestamo;
import com.biblio2.biblio2.domain.entity.Usuario;
import com.biblio2.biblio2.domain.entity.Libro;
import com.biblio2.biblio2.domain.port.PrestamoRepositoryPort;
import com.biblio2.biblio2.domain.port.UsuarioRepositoryPort;
import com.biblio2.biblio2.domain.port.LibroRepositoryPort;
import com.biblio2.biblio2.domain.exception.PrestamoNoDisponibleException;
import com.biblio2.biblio2.domain.exception.UsuarioNoEncontradoException;
import com.biblio2.biblio2.domain.exception.LibroNoEncontradoException;
import com.biblio2.biblio2.domain.usecase.prestamo.*;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

/**
 * Servicio de Aplicación: Préstamo
 * Orquesta los casos de uso relacionados con préstamos
 * Implementa las interfaces de casos de uso y delega en los puertos
 */
/**
 * Servicio de Aplicación: Préstamo
 * Orquesta los casos de uso relacionados con préstamos
 * Implementa la interfaz PrestamoUseCases para evitar conflictos de métodos
 */
@Service
public class PrestamoApplicationService implements PrestamoUseCases {

    private final PrestamoRepositoryPort prestamoRepository;
    private final UsuarioRepositoryPort usuarioRepository;
    private final LibroRepositoryPort libroRepository;

    /**
      * Constructor con inyección de dependencias
      * @param prestamoRepository Puerto de persistencia de préstamos
      * @param usuarioRepository Puerto de persistencia de usuarios
      * @param libroRepository Puerto de persistencia de libros
      */
    public PrestamoApplicationService(PrestamoRepositoryPort prestamoRepository,
                                      UsuarioRepositoryPort usuarioRepository,
                                      LibroRepositoryPort libroRepository) {
        this.prestamoRepository = prestamoRepository;
        this.usuarioRepository = usuarioRepository;
        this.libroRepository = libroRepository;
    }

    /**
     * Implementación del caso de uso: Crear Préstamo
     */
    @Override
    public Prestamo crearPrestamo(Long usuarioId, Long libroId) {
        // Obtener usuario
        Usuario usuario = usuarioRepository.obtenerPorId(usuarioId)
            .orElseThrow(() -> new UsuarioNoEncontradoException("Usuario con ID " + usuarioId + " no encontrado"));

        // Obtener libro
        Libro libro = libroRepository.obtenerPorId(libroId)
            .orElseThrow(() -> new LibroNoEncontradoException("Libro con ID " + libroId + " no encontrado"));

        // Validar disponibilidad del libro
        if (libro.isPrestado()) {
            throw new PrestamoNoDisponibleException("El libro '" + libro.getTitulo() + "' no está disponible para préstamo");
        }

        // Marcar libro como prestado
        libro.setPrestado(true);
        libroRepository.actualizar(libro);

        // Crear y guardar préstamo
        Prestamo prestamo = new Prestamo(usuario, libro, LocalDate.now());
        return prestamoRepository.guardar(prestamo);
    }

    /**
     * Implementación del caso de uso: Devolver Préstamo
     */
    @Override
    public void devolverPrestamo(Long prestamoId) {
        // Obtener préstamo
        Prestamo prestamo = prestamoRepository.obtenerPorId(prestamoId)
            .orElseThrow(() -> new RuntimeException("Préstamo con ID " + prestamoId + " no encontrado"));

        // Marcar como devuelto
        prestamo.setDevuelto(true);
        prestamo.setFechaDevolucion(LocalDate.now());

        // Marcar libro como no prestado
        Libro libro = prestamo.getLibro();
        libro.setPrestado(false);
        libroRepository.actualizar(libro);

        // Actualizar préstamo
        prestamoRepository.actualizar(prestamo);
    }

    /**
     * Implementación del caso de uso: Renovar Préstamo
     */
    @Override
    public Prestamo renovarPrestamo(Long prestamoId) {
        // Obtener préstamo
        Prestamo prestamo = prestamoRepository.obtenerPorId(prestamoId)
            .orElseThrow(() -> new RuntimeException("Préstamo con ID " + prestamoId + " no encontrado"));

        // Extender fecha de devolución por 7 días
        if (prestamo.getFechaDevolucion() != null) {
            prestamo.setFechaDevolucion(prestamo.getFechaDevolucion().plusDays(7));
        } else {
            prestamo.setFechaDevolucion(LocalDate.now().plusDays(7));
        }

        return prestamoRepository.actualizar(prestamo);
    }

    /**
     * Implementación del caso de uso: Listar Préstamos por Usuario
     */
    @Override
    public List<Prestamo> listarPorUsuario(Long usuarioId) {
        // Verificar que el usuario existe
        usuarioRepository.obtenerPorId(usuarioId)
            .orElseThrow(() -> new UsuarioNoEncontradoException("Usuario con ID " + usuarioId + " no encontrado"));

        return prestamoRepository.obtenerPorUsuario(usuarioId);
    }
}


