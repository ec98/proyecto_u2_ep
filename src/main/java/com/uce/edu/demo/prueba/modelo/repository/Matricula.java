package com.uce.edu.demo.prueba.modelo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {

	@Id
	@Column(name = "matri_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matri_id_seq")
	@SequenceGenerator(name = "matri_id_seq", sequenceName = "matri_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "matri_fechaMatricula")
	private LocalDateTime fechaMatricula;

	@Column(name = "matri_valorMatricula")
	private BigDecimal valorMatricula;

	@OneToOne(mappedBy = "matricula", cascade = CascadeType.ALL)
	private Propietario propietario;
	
	@OneToOne(mappedBy = "matricula", cascade = CascadeType.ALL)
	private Vehiculo vehiculo;

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fechaMatricula=" + fechaMatricula + ", valorMatricula=" + valorMatricula
				+ ", propietario=" + propietario + "]";
	}

	// GETTERS AND SETTERS

	public LocalDateTime getFechaMatricula() {
		return fechaMatricula;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public void setFechaMatricula(LocalDateTime fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public BigDecimal getValorMatricula() {
		return valorMatricula;
	}

	public void setValorMatricula(BigDecimal valorMatricula) {
		this.valorMatricula = valorMatricula;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
