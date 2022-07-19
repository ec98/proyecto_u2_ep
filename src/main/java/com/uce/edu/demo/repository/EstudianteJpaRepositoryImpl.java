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

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.EstudianteContadorCarrera;
import com.uce.edu.demo.repository.modelo.EstudianteSencillo;

@Repository
@Transactional
public class EstudianteJpaRepositoryImpl implements IEstudianteJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}

	@Override
	public Estudiante buscarporCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, cedula);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Estudiante estudiante = this.buscarporCedula(cedula);
		this.entityManager.remove(estudiante);
	}

	@Override
	public Estudiante buscarPorCedulaTyped(String cedula) {
		// SELECT id, nombre, apellido, cedula, carrera FROM public.estudiante;
		TypedQuery<Estudiante> miTypedQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.cedula =: datoCedula", Estudiante.class);
		miTypedQuery.setParameter("datoCedula", cedula);
		return miTypedQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorNombreApellidoTyped(String nombre, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> miTypedQuery = this.entityManager.createQuery(
				"SELECT e FROM Estudiante e WHERE e.nombre =: datoNombre AND e.apellido =: datoApellido",
				Estudiante.class);
		miTypedQuery.setParameter("datoNombre", nombre);
		miTypedQuery.setParameter("datoApellido", apellido);
		return miTypedQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorCedulaTyped");
		myQuery.setParameter("datoCedula", cedula);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorNombreApellidoNamed(String nombre, String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombreApellidoTyped");
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		return (List<Estudiante>) myQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorCedulaTyped",
				Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorNombreApellidoTypedNamed(String nombre, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createNamedQuery("Estudiante.buscarPorNombreApellidoTypedNamed", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();

	}

	@Override
	public Estudiante buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE estu_cedula =:datoCedula",
				Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorNombreApellidoCarreraNative(String nombre, String apellido, String carrera) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery(
				"SELECT * FROM Estudiante WHERE estu_nombre =:datoNombre AND estu_apellido =:datoApellido AND estu_carrera =:datoCarrera",
				Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoCarrera", carrera);
		return (List<Estudiante>) myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorApellidoCarreraNamedNative(String apellido, String carrera) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager
				.createNamedQuery("Estudiante.buscarPorApellidoCarreraNamedNative", Estudiante.class);
		myTypedQuery.setParameter("datoApellido", apellido);
		myTypedQuery.setParameter("datoCarrera", carrera);
		return myTypedQuery.getResultList();
	}

	@Override
	public List<EstudianteSencillo> buscarPorApellidoCarreraCedulaSencillo(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteSencillo> miQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.EstudianteSencillo(e.apellido,e.carrera,e.cedula) FROM Estudiante e WHERE e.apellido =: datoApellido",
				EstudianteSencillo.class);
		miQuery.setParameter("datoApellido", apellido);
		return miQuery.getResultList();
	}

	@Override
	public int eliminarNombreApellidoCarreraCedulaNamedNative(String nombre, String apellido, String carrera,
			String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager
				.createNamedQuery("Estudiante.eliminarNombreApellidoCarreraCedulaNamedNative", Estudiante.class);
		myTypedQuery.setParameter("datoNombre", nombre);
		myTypedQuery.setParameter("datoApellido", apellido);
		myTypedQuery.setParameter("datoCarrera", carrera);
		myTypedQuery.setParameter("datoCedula", cedula);
		return myTypedQuery.executeUpdate();
	}

	@Override
	public List<Estudiante> buscarPorNombreApellidoCriteriaApi(String nombre, String apellido) {
		// TODO Auto-generated method stub
		CriteriaBuilder miBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = miBuilder.createQuery(Estudiante.class);

		// Hacemos un Root FROM para la construccion del SQL
		Root<Estudiante> estudianteRoot = myQuery.from(Estudiante.class);
		Predicate p1 = miBuilder.equal(estudianteRoot.get("nombre"), nombre);
		Predicate p2 = miBuilder.equal(estudianteRoot.get("apellido"), apellido);

		myQuery.select(estudianteRoot).where(p1);
		myQuery.select(estudianteRoot).where(p2);

		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getResultList();
	}

	@Override
	public Estudiante buscarPorCedulaCarreraCriteriaApi(String cedula, String carrera) {
		// TODO Auto-generated method stub
		CriteriaBuilder miBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = miBuilder.createQuery(Estudiante.class);

		// Hacemos un Root FROM para la construccion del SQL
		Root<Estudiante> myTable = myQuery.from(Estudiante.class);

		Predicate p1 = miBuilder.equal(myTable.get("cedula"), cedula);
		Predicate p2 = miBuilder.equal(myTable.get("carrera"), carrera);

		Predicate pT = null;
		// Comparamos si el estudiante pertenece a la carrera c1,c2 o c3.
		if (carrera.equals("Computacion")) {
			pT = miBuilder.and(p1, p2);
		} else if (carrera.equals("Matematicas")) {
			pT = miBuilder.and(p1, p2);
		} else {
			pT = miBuilder.and(p1, p2);
		}
		myQuery.select(myTable).where(pT);

		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);

		return myQueryFinal.getSingleResult();
	}

	@Override
	public List<EstudianteContadorCarrera> contadorGeneralCarrera() {
		// select estu_carrera, count(estu_carrera), estu_apellido, estu_nombre from
		// estudiante group by estu_carrera, estu_apellido, estu_nombre
		// SELECT e.carrera, COUNT(e.carrera), e.apellido, e.nombre FROM Estudiante e
		// GROUP BY e.carrera, e.apellido, e.nombre
		// SELECT NEW
		// com.uce.edu.demo.repository.modelo.EstudianteContadorCarrera(e.carrera,
		// COUNT(e.carrera), e.apellido, e.nombre)) FROM Estudiante e GROUP BY
		// e.carrera, e.apellido, e.nombre
		TypedQuery<EstudianteContadorCarrera> miQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.EstudianteContadorCarrera(e.carrera, COUNT(e.carrera), e.apellido, e.nombre) FROM Estudiante e GROUP BY e.carrera, e.apellido, e.nombre",
				EstudianteContadorCarrera.class);
		return miQuery.getResultList();
	}

}
