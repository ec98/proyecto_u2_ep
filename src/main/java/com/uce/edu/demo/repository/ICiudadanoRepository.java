package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Ciudadano;

public interface ICiudadanoRepository {

	public void insertar(Ciudadano ciudadano);
	
	public Ciudadano buscar(Integer id);
	
	public void eliminar(Integer id);
	
	public void actualizar(Ciudadano ciudadano);
}
