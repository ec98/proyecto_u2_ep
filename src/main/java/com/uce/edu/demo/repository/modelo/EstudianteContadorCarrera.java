package com.uce.edu.demo.repository.modelo;

public class EstudianteContadorCarrera {

	private String carrera;
	private Long numero;
	private String apellido;
	private String nombre;

	public EstudianteContadorCarrera() {

	}

	public EstudianteContadorCarrera(String carrera, Long numero, String apellido, String nombre) {
		super();
		this.carrera = carrera;
		this.numero = numero;
		this.apellido = apellido;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "EstudianteContadorCarrera [carrera=" + carrera + ", numero=" + numero + ", apellido=" + apellido
				+ ", nombre=" + nombre + "]";
	}

	// GETTERS AND SETTERS

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
