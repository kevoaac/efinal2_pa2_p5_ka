package com.uce.edu.service;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.modelo.Estudiante;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceImpl implements IEstudianteService {
    @Autowired
    private IEstudianteRepository iEstudianteRepository;

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public void guardar(Estudiante estudiante) {
        this.iEstudianteRepository.insertar(estudiante);
    }

    @Override
    public Estudiante buscarPorCedula(String cedula) {
        return this.iEstudianteRepository.seleccionarPorCedula(cedula);
    }
}
