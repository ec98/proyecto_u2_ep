package com.uce.edu.demo.service;

import com.uce.edu.demo.modelo.to.Persona;

public interface IPersonaJdbcService {
	
	public void guardar(Persona persona);
	
	public void actualizar(Persona persona);
	
	public void eliminar(int id);
	
	public Persona buscarporId(int id);
}
