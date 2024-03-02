package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    void insertar(Estudiante estudiante);

    Estudiante seleccionarPorCedula(String cedula);
}
