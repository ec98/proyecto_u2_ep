package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.to.PersonaTo;
import com.uce.edu.demo.repository.IPersonaJdbcRepository;

@Service
public class PersonaJdbcServiceImpl implements IPersonaJdbcService {

	@Autowired
	IPersonaJdbcRepository iPersonaJdbcRepository;

	@Override
	public void guardar(PersonaTo persona) {
		this.iPersonaJdbcRepository.insertar(persona);
	}

	@Override
	public void actualizar(PersonaTo persona) {
		this.iPersonaJdbcRepository.actualizar(persona);
	}

	@Override
	public void eliminar(int id) {
		this.iPersonaJdbcRepository.eliminar(id);
	}

	@Override
	public PersonaTo buscarporId(int id) {
		return this.iPersonaJdbcRepository.buscarporId(id);
	}

	@Override
	public List<PersonaTo> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iPersonaJdbcRepository.buscarTodos();
	}

}
