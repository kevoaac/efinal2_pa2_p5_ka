package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Materia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class MateriaRepositoryImpl implements IMateriaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(value = Transactional.TxType.MANDATORY)
    public void insertar(Materia materia) {
        this.entityManager.persist(materia);
    }

    @Override
    @Transactional(value = Transactional.TxType.NOT_SUPPORTED)
    public Materia seleccionarPorCodigo(String codigo) {
        TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.codigo = :codigo", Materia.class);
        myQuery.setParameter("codigo", codigo);
        return myQuery.getSingleResult();
    }
}
