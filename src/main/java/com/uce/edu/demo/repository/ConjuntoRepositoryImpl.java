package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Conjunto;

@Repository
@Transactional
public class ConjuntoRepositoryImpl implements IConjuntoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Conjunto conjunto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(conjunto);
	}

	@Override
	public void actualizar(Conjunto conjunto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(conjunto);
	}

	@Override
	public Conjunto buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Conjunto.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Conjunto conjunto = this.buscar(id);
		this.entityManager.remove(conjunto);
	}

}
