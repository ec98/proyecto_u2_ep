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
	public Estudiante buscar(String cedula) {
		return this.iEstudianteJdbcRepository.buscar(cedula);
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
	public void eliminar(String cedula) {
		this.iEstudianteJdbcRepository.eliminar(cedula);
	}
}
