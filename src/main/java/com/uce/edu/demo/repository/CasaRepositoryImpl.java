package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Casa;

@Repository
@Transactional
public class CasaRepositoryImpl implements ICasaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Casa casas) {
		// TODO Auto-generated method stub
		this.entityManager.persist(casas);
	}

	@Override
	public void actualizar(Casa casas) {
		// TODO Auto-generated method stub
		this.entityManager.merge(casas);
	}

	@Override
	public Casa Buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Casa.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Casa casa = this.Buscar(id);
		this.entityManager.remove(casa);
	}

}
