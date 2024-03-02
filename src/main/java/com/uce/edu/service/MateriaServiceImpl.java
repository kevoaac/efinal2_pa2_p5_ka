package com.uce.edu.service;

import com.uce.edu.repository.IMateriaRepository;
import com.uce.edu.repository.modelo.Materia;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaServiceImpl implements IMateriaService {
    @Autowired
    private IMateriaRepository iMateriaRepository;

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public void guardar(Materia materia) {
        this.iMateriaRepository.insertar(materia);
    }

    @Override
    public Materia buscarPorCodigo(String codigo) {
        return this.iMateriaRepository.seleccionarPorCodigo(codigo);
    }
}
