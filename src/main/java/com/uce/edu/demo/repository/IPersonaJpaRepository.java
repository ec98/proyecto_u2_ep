package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaRepository {

	public List<Persona> buscarporNombre(String nombre);

	public List<Persona> buscarporGenero(String genero);

	public List<Persona> buscarporApellido(String apellido);

	// buscar por nombre y apellido
	public List<Persona> buscarporNombreApellido(String nombre, String apellido);

	public Persona buscarporCedula(String cedula);

	// Typed
	public Persona buscarporCedulaTyped(String cedula);

	// Named
	public Persona buscarporCedulaNamed(String cedula);

	// TypedNamed
	public Persona buscarporCedulaTypedNamed(String cedula);

	// Buscar por cedula Native
	public Persona buscarporCedulaNative(String cedula);

	// Buscar por cedula Named Native
	public Persona buscarporCedulaNamedNative(String cedula);

	// Buscar por cedula Criteria Api
	public Persona buscarporCedulaCriteriaApi(String cedula);

	// Dinamico
	public Persona buscarDinamicamente(String nombre, String apellido, String genero);

	public Persona buscarporId(Integer id);

	public void insertar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminar(Integer id);

	// UPDATE
	public int actualizarporApellido(String genero, String apellido);

	// DELETE
	public int eliminarporGenero(String genero);
}
