package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {

	public List<Persona> buscarporNombre(String nombre);
	public List<Persona> buscarporGenero(String genero);
	public List<Persona> buscarporApellido(String apellido);
	public Persona buscarporCedula(String cedula);
	public void guardar(Persona persona);
	public void actualizar(Persona persona);
	public void eliminar(Integer id);
	public Persona buscarporId(Integer id);

	// UPDATE
	public int actualizarporApellido(String genero, String apellido);

	// DELETE
	public int eliminarporGenero(String genero);
}
