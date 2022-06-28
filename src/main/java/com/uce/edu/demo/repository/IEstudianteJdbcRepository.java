package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.to.Estudiante;

public interface IEstudianteJdbcRepository {

	public Estudiante buscar(String cedula);

	public void insert(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(String cedula);

}
