package com.uce.edu.demo.prueba.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.modelo.repository.Propietario;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(propietario);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Propietario propietario = this.consultar(cedula);
		this.entityManager.remove(propietario);
	}

	@Override
	public Propietario consultar(String cedula) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Propietario.class, cedula);
	}

}
