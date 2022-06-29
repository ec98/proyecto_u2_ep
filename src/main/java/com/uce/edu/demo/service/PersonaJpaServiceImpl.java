package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJpaRepository;
import com.uce.edu.demo.repository.modelo.Persona;

@Service
public class PersonaJpaServiceImpl implements IPersonaJpaService {

	@Autowired
	private IPersonaJpaRepository iPersonaJpaRepository;

	@Override
	public void guardar(Persona persona) {
		this.iPersonaJpaRepository.insertar(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		this.iPersonaJpaRepository.actualizar(persona);
	}

	@Override
	public void eliminar(Integer id) {
		this.iPersonaJpaRepository.eliminar(id);
	}

	@Override
	public Persona buscarporId(Integer id) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarporId(id);
	}

}
