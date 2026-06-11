package com.biblio2.biblio2.infrastructure.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entidad JPA: Préstamo
 * Mapea la entidad de dominio Préstamo a la tabla prestamos en la base de datos
 */
@Entity
@Table(name = "prestamos")
public class PrestamoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id", nullable = false)
    private LibroEntity libro;

    @Column(nullable = false)
    private LocalDate fechaPrestamo;

    @Column
    private LocalDate fechaDevolucion;

    @Column(nullable = false)
    private boolean devuelto = false;

    /**
     * Constructor sin argumentos
     */
    public PrestamoEntity() {
    }

    /**
     * Constructor con argumentos
     */
    public PrestamoEntity(UsuarioEntity usuario, LibroEntity libro, LocalDate fechaPrestamo) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.devuelto = false;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public LibroEntity getLibro() {
        return libro;
    }

    public void setLibro(LibroEntity libro) {
        this.libro = libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    @Override
    public String toString() {
        return "PrestamoEntity{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", libro=" + libro +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                ", devuelto=" + devuelto +
                '}';
    }
}

