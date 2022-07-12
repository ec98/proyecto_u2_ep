package com.uce.edu.demo.service;

import java.util.List;

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
		return this.iPersonaJpaRepository.buscarporId(id);
	}

	@Override
	public Persona buscarporCedula(String cedula) {
		return this.iPersonaJpaRepository.buscarporCedula(cedula);
	}

	@Override
	public Persona buscarporCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarporCedulaTyped(cedula);
	}

	@Override
	public Persona buscarporCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarporCedulaNamed(cedula);
	}

	@Override
	public Persona buscarporCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarporCedulaTypedNamed(cedula);
	}

	@Override
	public List<Persona> buscarporApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarporApellido(apellido);
	}

	@Override
	public List<Persona> buscarporNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarporNombreApellido(nombre, apellido);
	}

	@Override
	public List<Persona> buscarporNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarporNombre(nombre);
	}

	@Override
	public List<Persona> buscarporGenero(String genero) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarporGenero(genero);
	}

	@Override
	public int actualizarporApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.actualizarporApellido(genero, apellido);
	}

	@Override
	public int eliminarporGenero(String genero) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.eliminarporGenero(genero);
	}

}
