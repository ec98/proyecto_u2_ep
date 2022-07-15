package com.uce.edu.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
@NamedQuery(name = "Estudiante.buscarPorCedulaTyped", query = "SELECT e FROM Estudiante e WHERE e.cedula =: datoCedula")
@NamedQuery(name = "Estudiante.buscarPorNombreApellidoTyped", query = "SELECT e FROM Estudiante e WHERE e.nombre =: datoNombre AND e.apellido =: datoApellido")
@NamedQuery(name = "Estudiante.buscarPorNombreApellidoTypedNamed", query = "SELECT e FROM Estudiante e WHERE e.nombre =: datoNombre AND e.apellido =: datoApellido")

@NamedNativeQueries({
		@NamedNativeQuery(name = "Estudiante.buscarPorApellidoCarreraNamedNative", query = "SELECT * FROM Estudiante WHERE estu_apellido =:datoApellido AND estu_carrera =:datoCarrera", resultClass = Estudiante.class),
		@NamedNativeQuery(name = "Estudiante.eliminarNombreApellidoCarreraCedulaNamedNative", query = "DELETE FROM Estudiante WHERE estu_nombre =:datoNombre AND estu_apellido =:datoApellido AND estu_carrera =:datoCarrera AND estu_cedula =:datoCedula", resultClass = Estudiante.class) })

public class Estudiante {

	@Column(name = "estu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estu_id")
	@SequenceGenerator(name = "estu_id", sequenceName = "estu_id", allocationSize = 1)
	private Integer id; // "matricula"

	@Column(name = "estu_nombre")
	private String nombre;

	@Column(name = "estu_apellido")
	private String apellido;

	@Id // referencia a lo que voy a buscar
	@Column(name = "estu_cedula")
	private String cedula;

	@Column(name = "estu_carrera")
	private String carrera;

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", carrera=" + carrera + "]";
	}

	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

}
