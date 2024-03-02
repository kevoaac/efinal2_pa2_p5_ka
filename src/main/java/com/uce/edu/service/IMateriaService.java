package com.uce.edu.service;

import com.uce.edu.repository.modelo.Materia;

public interface IMateriaService {
    void guardar(Materia materia);

    Materia buscarPorCodigo(String codigo);
}
