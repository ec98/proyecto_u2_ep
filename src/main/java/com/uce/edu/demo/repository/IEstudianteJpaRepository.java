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

	public void crear(Estudiante estudiante);

	public Estudiante buscarporCedula(String cedula);

	public void actualizar(Estudiante estudiante);

	public void eliminar(String cedula);

}
