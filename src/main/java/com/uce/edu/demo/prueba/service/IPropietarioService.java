package com.uce.edu.demo.prueba.service;

import com.uce.edu.demo.prueba.modelo.repository.Propietario;

public interface IPropietarioService {

	public void crear(Propietario propietario);

	public void eliminar(String cedula);

}
