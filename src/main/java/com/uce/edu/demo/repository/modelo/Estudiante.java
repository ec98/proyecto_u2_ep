package com.uce.edu.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Estudiante")
public class Estudiante {

	@Id
	@Column(name = "estu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estu_id_seq")
	@SequenceGenerator(name = "estu_id_seq", sequenceName = "estu_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "estu_nombre")
	private String nombre;

	@Column(name = "estu_apellido")
	private String apellido;

	@Column(name = "estu_carrera")
	private String carrera;

	// tabla principal
//	@OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL)
//	private Pasaporte conserje;

//	@Override
//	public String toString() {
//		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", carrera=" + carrera
//				+ ", conserje=" + conserje + "]";
//	}
	
	// GETTERS AND SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

//	public Pasaporte getConserje() {
//		return conserje;
//	}
//
//	public void setConserje(Pasaporte conserje) {
//		this.conserje = conserje;
//	}

}
