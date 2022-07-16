package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
	public Persona buscarporCedulaNative(String cedula) {
		Query miQuery = this.entityManager.createNativeQuery("SELECT * FROM persona WHERE pers_cedula = :datoCedula",
				Persona.class); // Retorna un Query
		miQuery.setParameter("datoCedula", cedula);
		return (Persona) miQuery.getSingleResult();
	}

	@Override
	public Persona buscarporCedulaNamedNative(String cedula) {
		TypedQuery<Persona> myTypedQuery = this.entityManager.createNamedQuery("Persona.buscarporCedulaNative",
				Persona.class);
		myTypedQuery.setParameter("datoCedula", cedula);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Persona buscarporCedulaCriteriaApi(String cedula) {
		// Creamos una instancia de la interfaz CriteriaBuilder, donde es una Fabrica
		// para construir el SQL
		CriteriaBuilder miBuilder = this.entityManager.getCriteriaBuilder();

		// Especificamos un retorno de mi SQL
		CriteriaQuery<Persona> myQuery = miBuilder.createQuery(Persona.class);

		// Aqui empezamos a construir el SQL
		// Root FROM
		Root<Persona> personaRoot = myQuery.from(Persona.class); // FROM Persona
		// myQuery.select(personaRoot); //SELECT p FROM Persona
		// Las condiciones where en criteria API se los conoce como predicados.
		Predicate p1 = miBuilder.equal(personaRoot.get("cedula"), cedula); // p.cedula =: datoCedula

//		CriteriaQuery<Persona> miQueryCompleto = myQuery.select(personaRoot).where(p1);
		myQuery.select(personaRoot).where(p1);

		// Finalizado mi Query Completo
		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getSingleResult();
	}

	@Override
	public Persona buscarDinamicamente(String nombre, String apellido, String genero) {
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);

		Root<Persona> myTable = myQuery.from(Persona.class);

		// pers_nombre = ?
		Predicate predicadoNombre = myCriteria.equal(myTable.get("nombre"), nombre);

		// pers_apellido = ?
		Predicate predicadoApellido = myCriteria.equal(myTable.get("apellido"), apellido);

		Predicate miPredicadoFinal = null;
		if (genero.equals("Masculino")) {
			// pers_nombre = ? AND pers_apellido=?
			miPredicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
		} else {
			miPredicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
		}
		myQuery.select(myTable).where(miPredicadoFinal);
		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);

		return myQueryFinal.getSingleResult();
	}

	public Persona buscarDinamicamentePredicados(String nombre, String apellido, String genero) {
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);

		Root<Persona> myTable = myQuery.from(Persona.class);

		Predicate predicadoNombre = myCriteria.equal(myTable.get("nombre"), nombre);
		Predicate predicadoApellido = myCriteria.equal(myTable.get("apellido"), apellido);
		Predicate predicadoGenero = myCriteria.equal(myTable.get("genero"), genero);

		Predicate miPredicadoFinal = null;
		// (pers_apellido='Gomez' or pers_nombre ='Carla') and pers_genero ='Masculino';
		if (genero.equals("Masculino")) {
			miPredicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
			miPredicadoFinal = myCriteria.and(miPredicadoFinal, predicadoGenero);
		} else {
			miPredicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
			miPredicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
		}
		myQuery.select(myTable).where(miPredicadoFinal);
		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);

		return myQueryFinal.getSingleResult();
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
