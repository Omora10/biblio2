package com.biblio2.biblio2.infrastructure.persistence.entity;

import javax.persistence.*;

/**
 * Entidad JPA: Usuario
 * Mapea la entidad de dominio Usuario a la tabla usuarios en la base de datos
 */
@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    /**
     * Constructor sin argumentos
     */
    public UsuarioEntity() {
    }

    /**
     * Constructor con argumentos
     */
    public UsuarioEntity(String nombre, String email, String password) {
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
        return "UsuarioEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

