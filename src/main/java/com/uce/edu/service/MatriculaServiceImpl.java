package com.uce.edu.service;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.IMateriaRepository;
import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.service.to.MatriculaTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {
    @Autowired
    private IMatriculaRepository iMatriculaRepository;
    @Autowired
    private IMateriaRepository iMateriaRepository;
    @Autowired
    private IEstudianteRepository iEstudianteRepository;

    @Override
    public void guardar(Matricula matricula) {
        this.iMatriculaRepository.insertar(matricula);
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public void actualizar(Matricula matricula) {
        this.iMatriculaRepository.actualizar(matricula);
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public void actualizar(List<Matricula> matriculas) {
        matriculas.parallelStream().forEach(matricula -> {
            matricula.setFechaMatricula(LocalDateTime.now());
            matricula.setNombreHilo(Thread.currentThread().getName());
            this.iMatriculaRepository.actualizar(matricula);
        });
    }


    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public void generarMatriculas(MatriculaTO matriculaTO) {
        Estudiante estudiante = this.iEstudianteRepository.seleccionarPorCedula(matriculaTO.getCedulaEstudiante());
//        String cedulaEstudiante = estudiante.getCedula();

        Matricula m1 = new Matricula();
        m1.setMateria(this.iMateriaRepository.seleccionarPorCodigo(matriculaTO.getCodigoMateria1()));
        m1.setEstudiante(estudiante);

        Matricula m2 = new Matricula();
        m2.setMateria(this.iMateriaRepository.seleccionarPorCodigo(matriculaTO.getCodigoMateria2()));
        m2.setEstudiante(estudiante);

        Matricula m3 = new Matricula();
        m3.setMateria(this.iMateriaRepository.seleccionarPorCodigo(matriculaTO.getCodigoMateria3()));
        m3.setEstudiante(estudiante);

        Matricula m4 = new Matricula();
        m4.setMateria(this.iMateriaRepository.seleccionarPorCodigo(matriculaTO.getCodigoMateria4()));
        m4.setEstudiante(estudiante);

        List<Matricula> matriculas = Arrays.asList(m1, m2, m3, m4);
        this.actualizar(matriculas);
    }

    @Override
    public List<MatriculaDTO> buscarTodasDTO() {
        return this.iMatriculaRepository.seleccionarTodasDTO();
    }

}
