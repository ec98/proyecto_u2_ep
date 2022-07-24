package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetomany.Casa;

public interface ICasaRepository {

	public void insertar(Casa casas);

	public void actualizar(Casa casas);

	public Casa Buscar(Integer id);

	public void eliminar(Integer id);
}
