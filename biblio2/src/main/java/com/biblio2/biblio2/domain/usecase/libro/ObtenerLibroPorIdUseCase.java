package com.biblio2.biblio2.domain.usecase.libro;

import com.biblio2.biblio2.domain.entity.Libro;

public interface ObtenerLibroPorIdUseCase {
    Libro ejecutar(Long id);
}

