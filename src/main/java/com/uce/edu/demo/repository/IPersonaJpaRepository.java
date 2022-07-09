package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaRepository {
	
	public List<Persona> buscarporNombre(String nombre);
	public List<Persona> buscarporGenero(String genero);
	public List<Persona> buscarporApellido(String apellido);
	public Persona buscarporCedula(String cedula);
	public Persona buscarporId(Integer id);
	public void insertar(Persona persona);
	public void actualizar(Persona persona);
	public void eliminar(Integer id);
	
	//UPDATE
	public int actualizarporApellido(String genero, String apellido);
	//DELETE
	public int eliminarporGenero(String genero);
}
