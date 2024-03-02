package com.uce.edu.service;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.service.to.MatriculaTO;

import java.util.List;

public interface IMatriculaService {
    void guardar(Matricula matricula);

    void actualizar(Matricula matricula);

    void actualizar(List<Matricula> matriculas);

    void generarMatriculas(MatriculaTO matriculaTO);

    List<MatriculaDTO> buscarTodasDTO();

}
