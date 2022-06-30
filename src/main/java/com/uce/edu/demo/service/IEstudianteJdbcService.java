package com.uce.edu.demo.service;

import com.uce.edu.demo.modelo.to.EstudianteTo;

public interface IEstudianteJdbcService {

	public EstudianteTo buscar(String cedula);

	public void insertar(EstudianteTo estudiante);

	public void actualizar(EstudianteTo estudiante);

	public void eliminar(String cedula);
}
