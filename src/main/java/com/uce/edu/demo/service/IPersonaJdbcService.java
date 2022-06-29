package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.modelo.to.PersonaTo;

public interface IPersonaJdbcService {
	
	public List<PersonaTo> buscarTodos();
	
	public void guardar(PersonaTo persona);
	
	public void actualizar(PersonaTo persona);
	
	public void eliminar(int id);
	
	public PersonaTo buscarporId(int id);
}
