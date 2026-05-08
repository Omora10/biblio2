package com.biblio2.biblio2.application.dto;

public class PrestamoRequest {
    private Long usuarioId;
    private Long libroId;

    public PrestamoRequest() {
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }
}

