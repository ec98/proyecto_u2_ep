package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.onetomany.Conjunto;

public interface IConjuntoService {

	public void insertar(Conjunto conjunto);

	public void actualizar(Conjunto conjunto);

	public Conjunto buscar(Integer id);

	public void eliminar(Integer id);
}
