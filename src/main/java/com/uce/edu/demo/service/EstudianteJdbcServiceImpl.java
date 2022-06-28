package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.to.Estudiante;
import com.uce.edu.demo.repository.IEstudianteJdbcRepository;

@Service
public class EstudianteJdbcServiceImpl implements IEstudianteJdbcService {

	@Autowired
	private IEstudianteJdbcRepository iEstudianteJdbcRepository;

	@Override
	public Estudiante buscar(int id) {
		return this.iEstudianteJdbcRepository.buscar(id);
	}

	@Override
	public void insert(Estudiante estudiante) {
		this.iEstudianteJdbcRepository.insert(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.iEstudianteJdbcRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(int id) {
		this.iEstudianteJdbcRepository.eliminar(id);
	}
	
}
