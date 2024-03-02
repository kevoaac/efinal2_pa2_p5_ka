package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
//    @Transactional(value = Transactional.TxType.MANDATORY)
    public void insertar(Matricula matricula) {
        this.entityManager.persist(matricula);
    }

    @Override
//    @Transactional(value = Transactional.TxType.MANDATORY)
    //Al llamarse desde ejecucion en paralelo no se generan las transacciones necesarias
    public void actualizar(Matricula matricula) {
        this.entityManager.merge(matricula);
    }

    @Override
    @Transactional(value = Transactional.TxType.NOT_SUPPORTED)
    public List<MatriculaDTO> seleccionarTodasDTO() {
        TypedQuery<MatriculaDTO> myQuery = this.entityManager.createQuery("SELECT NEW com.uce.edu.repository.modelo.dto.MatriculaDTO(e.cedula, ma.codigo, m.fechaMatricula, m.nombreHilo) " +
                "FROM Matricula m " +
                "JOIN m.estudiante e " +
                "JOIN m.materia ma", MatriculaDTO.class);
        return myQuery.getResultList();
    }

}