package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.to.EstudianteTo;
import com.uce.edu.demo.repository.IEstudianteJdbcRepository;

@Service
public class EstudianteJdbcServiceImpl implements IEstudianteJdbcService{

	@Autowired
	private IEstudianteJdbcRepository iEstudianteJdbcRepository;
	
	@Override
	public EstudianteTo buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.iEstudianteJdbcRepository.buscar(cedula);
	}

	@Override
	public void insertar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteJdbcRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteJdbcRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.iEstudianteJdbcRepository.eliminar(cedula);
	}

}
