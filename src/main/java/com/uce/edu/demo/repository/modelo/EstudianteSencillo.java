package com.uce.edu.demo.repository.modelo;

public class EstudianteSencillo {

	private String apellido;
	private String cedula;
	private String carrera;

	public EstudianteSencillo() {

	}

	public EstudianteSencillo(String apellido, String cedula, String carrera) {
		super();
		this.apellido = apellido;
		this.cedula = cedula;
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "EstudianteSencillo [apellido=" + apellido + ", cedula=" + cedula + ", carrera=" + carrera + "]";
	}

	// GETTERS AND SETTERS
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

}
