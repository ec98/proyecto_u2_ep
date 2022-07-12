package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
	public Persona buscarporCedulaTyped(String cedula) {
		TypedQuery<Persona> miTypedQuery = this.entityManager
				.createQuery("SELECT p FROM Persona p WHERE p.cedula=:datoCedula", Persona.class);
		miTypedQuery.setParameter("datoCedula", cedula);
		return miTypedQuery.getSingleResult();
	}

	@Override
	public Persona buscarporCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Persona.buscarporCedulaTyped");
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}

	@Override
	public Persona buscarporCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarporCedulaTyped",
				Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Persona> buscarporGenero(String genero) {
		// TODO Auto-generated method stub
		Query myQueryv2 = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero=:datoGenero");
		myQueryv2.setParameter("datoGenero", genero);
		return myQueryv2.getResultList();
	}

	@Override
	public List<Persona> buscarporApellido(String apellido) {
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido=:datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarporNombreApellido(String nombre, String apellido) {
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorNombreApellido",
				Persona.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarporNombre(String nombre) {
		// TODO Auto-generated method stub
		Query myQueryv3 = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre=:datoNombre");
		myQueryv3.setParameter("datoNombre", nombre);
		return myQueryv3.getResultList();
	}

	@Override
	public int actualizarporApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		// update persona set pers_genero='F' where pers_apellido='Santanna'
		Query myQueryv4 = this.entityManager
				.createQuery("UPDATE Persona p SET p.genero =:datoGenero WHERE p.apellido=:datoApellido");
		myQueryv4.setParameter("datoGenero", genero);
		myQueryv4.setParameter("datoApellido", apellido);
		return myQueryv4.executeUpdate(); // this return a int, actualiza los registros.
	}

	@Override
	public int eliminarporGenero(String genero) {
		// TODO Auto-generated method stub
		// delete from persona where pers_apellido='Santanna'
		// AND p.apellido=:datoApellido (para mas complejidad)
		Query myQueryV5 = this.entityManager.createQuery("DELETE FROM Persona p WHERE p.genero=:genero");
		myQueryV5.setParameter("genero", genero);
		return myQueryV5.executeUpdate();
	}

}
