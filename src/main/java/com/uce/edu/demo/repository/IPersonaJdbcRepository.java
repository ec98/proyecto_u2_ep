package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.modelo.to.PersonaTo;

public interface IPersonaJdbcRepository {
	
	public List<PersonaTo> buscarTodos();
	
	public PersonaTo buscarporId(int id);

	public void insertar(PersonaTo persona);

	public void actualizar(PersonaTo persona);

	public void eliminar(int id);

	// public ArrayList<Persona> buscarporApellido(String apellido); //debe tener sentido lo que voy a buscar

}
