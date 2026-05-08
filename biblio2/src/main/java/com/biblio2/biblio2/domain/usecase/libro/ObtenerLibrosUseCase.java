package com.biblio2.biblio2.domain.usecase.libro;

import com.biblio2.biblio2.domain.entity.Libro;
import java.util.List;

public interface ObtenerLibrosUseCase {
    List<Libro> ejecutar();
}

