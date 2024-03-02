package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class EstudianteRepositoryImpl implements IEstudianteRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(value = Transactional.TxType.MANDATORY)
    public void insertar(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }


    @Override
    @Transactional(value = Transactional.TxType.NOT_SUPPORTED)
    public Estudiante seleccionarPorCedula(String cedula) {
        TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula= :cedula", Estudiante.class);
        myQuery.setParameter("cedula", cedula);
        return myQuery.getSingleResult();
    }
}
