package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteJpaRepository {
	
	public void crear(Estudiante estudiante);
	
	public Estudiante buscarporCedula(String cedula);
	
	public void actualizar(Estudiante estudiante);

	public void eliminar(String cedula);
	
}
