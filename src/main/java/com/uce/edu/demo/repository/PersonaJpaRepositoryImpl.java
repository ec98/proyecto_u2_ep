package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;

@Repository
@Transactional
public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Persona buscarporId(Integer id) {
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void insertar(Persona persona) {
		this.entityManager.persist(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		Persona persona = this.buscarporId(id);
		this.entityManager.remove(persona);
	}

	@Override
	public Persona buscarporCedula(String cedula) {
		// SELECT * FROM persona Where pers_cedula='1728392022';
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula=:datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);

		return (Persona) jpqlQuery.getSingleResult(); // Da un objeto de tipo Persona
	}

	@Override
	public List<Persona> buscarporGenero(String genero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> buscarporApellido(String apellido) {
		Query myQuery= this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido=:datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

}
