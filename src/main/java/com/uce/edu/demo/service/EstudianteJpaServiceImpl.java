package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.repository.modelo.Estudiante;

@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService {

	@Autowired
	private IEstudianteJpaRepository iEstudianteJpaRepository;

	@Override
	public Estudiante buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarporCedula(cedula);
	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteJpaRepository.crear(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteJpaRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.iEstudianteJpaRepository.eliminar(cedula);
	}

	@Override
	public Estudiante buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorCedulaTyped(cedula);
	}

	@Override
	public List<Estudiante> buscarPorNombreApellidoTyped(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorNombreApellidoTyped(nombre, apellido);
	}

	@Override
	public Estudiante buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorCedulaNamed(cedula);
	}

	@Override
	public List<Estudiante> buscarPorNombreApellidoNamed(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorNombreApellidoNamed(nombre, apellido);
	}

	@Override
	public Estudiante buscarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorCedulaTypedNamed(cedula);
	}

	@Override
	public List<Estudiante> buscarPorNombreApellidoTypedNamed(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorNombreApellidoTypedNamed(nombre, apellido);
	}

	@Override
	public Estudiante buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorCedulaNative(cedula);
	}

	@Override
	public List<Estudiante> buscarPorNombreApellidoCarreraNative(String nombre, String apellido, String carrera) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorNombreApellidoCarreraNative(nombre, apellido, carrera);
	}

	@Override
	public List<Estudiante> buscarPorApellidoCarreraNamedNative(String apellido, String carrera) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorApellidoCarreraNamedNative(apellido, carrera);
	}

	@Override
	public int eliminarNombreApellidoCarreraCedulaNamedNative(String nombre, String apellido, String carrera,
			String cedula) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.eliminarNombreApellidoCarreraCedulaNamedNative(nombre, apellido, carrera,
				cedula);
	}

	@Override
	public List<Estudiante> buscarPorNombreApellidoCriteriaApi(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorNombreApellidoCriteriaApi(nombre, apellido);
	}

	@Override
	public Estudiante buscarPorCedulaCarreraCriteriaApi(String cedula, String carrera) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorCedulaCarreraCriteriaApi(cedula, carrera);
	}


}
