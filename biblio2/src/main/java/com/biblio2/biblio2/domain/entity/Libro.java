package com.biblio2.biblio2.domain.entity;

/**
 * Entidad de dominio: Libro
 * Representa un libro en el sistema sin dependencias de Spring ni infraestructura.
 * Esta clase es agnóstica a la persistencia y transporte.
 */
public class Libro {

    private Long id;
    private String titulo;
    private String autor;
    private String isbn;

    /**
     * Constructor sin argumentos para frameworks de serialización
     */
    public Libro() {
    }

    /**
     * Constructor con argumentos
     */
    public Libro(Long id, String titulo, String autor, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    /**
     * Constructor para crear libro sin ID (nuevo libro)
     */
    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

