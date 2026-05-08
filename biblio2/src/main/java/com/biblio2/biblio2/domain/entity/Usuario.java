package com.biblio2.biblio2.domain.entity;

/**
 * Entidad de dominio: Usuario
 * Representa un usuario del sistema sin dependencias de Spring ni infraestructura.
 * Esta clase es agnóstica a la persistencia y transporte.
 */
public class Usuario {

    private Long id;
    private String nombre;
    private String email;
    private String password;

    /**
     * Constructor sin argumentos para frameworks de serialización
     */
    public Usuario() {
    }

    /**
     * Constructor con argumentos
     */
    public Usuario(Long id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor para crear usuario sin ID (nuevo usuario)
     */
    public Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

