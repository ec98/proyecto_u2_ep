package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.to.Persona;

public interface IPersonaJdbcRepository {
	
	public Persona buscarporId(int id);

	public void insertar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminar(int id);

	// public ArrayList<Persona> buscarporApellido(String apellido);

}
