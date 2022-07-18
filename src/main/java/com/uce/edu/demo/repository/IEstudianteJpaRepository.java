package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteJpaRepository {

	// Typed
	public Estudiante buscarPorCedulaTyped(String cedula);

	public List<Estudiante> buscarPorNombreApellidoTyped(String nombre, String apellido);

	// Named
	public Estudiante buscarPorCedulaNamed(String cedula);

	public List<Estudiante> buscarPorNombreApellidoNamed(String nombre, String apellido);

	// TypedNamed
	public Estudiante buscarPorCedulaTypedNamed(String cedula);

	public List<Estudiante> buscarPorNombreApellidoTypedNamed(String nombre, String apellido);

	// Native Query
	public Estudiante buscarPorCedulaNative(String cedula);

	public List<Estudiante> buscarPorNombreApellidoCarreraNative(String nombre, String apellido, String carrera);

	// NamedNativeQuery

	public List<Estudiante> buscarPorApellidoCarreraNamedNative(String apellido, String carrera);

	public int eliminarNombreApellidoCarreraCedulaNamedNative(String nombre, String apellido, String carrera,
			String cedula);

	// CriteriaApi

	public List<Estudiante> buscarPorNombreApellidoCriteriaApi(String nombre, String apellido);

	public Estudiante buscarPorCedulaCarreraCriteriaApi(String cedula, String carrera);

	public void crear(Estudiante estudiante);

	public Estudiante buscarporCedula(String cedula);

	public void actualizar(Estudiante estudiante);

	public void eliminar(String cedula);

}
