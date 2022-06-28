package com.uce.edu.demo.modelo.to;

public class Estudiante {
	
	private int id; // matricula
	private String nombre;
	private String apellido;
	private String cedula;
	private String carrera;

	// Constructor por defecto
	public Estudiante() {

	}

	// Constructor con parametros
	public Estudiante(String nombre, String apellido, String cedula, int id, String carrera) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.id = id;
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", id=" + id
				+ ", carrera=" + carrera + "]";
	}

	// GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
}
