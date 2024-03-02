package com.uce.edu.service;

import com.uce.edu.repository.modelo.Estudiante;

public interface IEstudianteService {
    void guardar(Estudiante estudiante);

    Estudiante buscarPorCedula(String cedula);
}
