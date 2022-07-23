package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICiudadanoRepository;
import com.uce.edu.demo.repository.modelo.onetoone.Ciudadano;

@Service
public class CiudadanoService implements ICiudadanoService{

	@Autowired
	private ICiudadanoRepository iCiudadanoRepository;
	
	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.insertar(ciudadano);
	}

	@Override
	public Ciudadano buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.eliminar(id);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.actualizar(ciudadano);
	}

}
