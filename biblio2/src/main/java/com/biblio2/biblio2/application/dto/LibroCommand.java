package com.biblio2.biblio2.application.dto;

/**
 * DTO de entrada (Command) para la capa de aplicación.
 * Transporta los datos necesarios para crear o actualizar un libro
 * sin exponer la entidad de dominio ni los DTOs de infraestructura.
 */
public class LibroCommand {

    private String titulo;
    private String autor;
    private String isbn;

    public LibroCommand() {}

    public LibroCommand(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
}

