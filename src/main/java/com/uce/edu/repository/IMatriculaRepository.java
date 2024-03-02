package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;

import java.util.List;

public interface IMatriculaRepository {
    void insertar(Matricula matricula);

    void actualizar(Matricula matricula);

    List<MatriculaDTO> seleccionarTodasDTO();

}
