package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Materia;

public interface IMateriaRepository {
    void insertar(Materia materia);

    Materia seleccionarPorCodigo(String codigo);
}
