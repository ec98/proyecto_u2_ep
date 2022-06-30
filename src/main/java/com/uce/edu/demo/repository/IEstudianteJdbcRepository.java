package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.to.EstudianteTo;

public interface IEstudianteJdbcRepository {
	
	public EstudianteTo buscar(String cedula);
	
	public void insertar(EstudianteTo estudiante);
	
	public void actualizar(EstudianteTo estudiante);
	
	public void eliminar(String cedula);
}
