package com.uce.edu.demo.prueba.modelo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {

	@Id
	@Column(name = "id")
	private Integer id; // "identificador de la matricula"

	@Column(name = "fechaMatricula")
	private LocalDateTime fechaMatricula;

	@Column(name = "valorMatricula")
	private BigDecimal valorMatricula;

//	@OneToOne
//	@JoinColumn(name="propietario")
//	private Propietario propietario;
//
//	@OneToOne
//	@JoinColumn(name="propietario")
//	private Vehiculo vehiculo;

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fechaMatricula=" + fechaMatricula + ", valorMatricula=" + valorMatricula
				+ "]";
	}

	// GETTERS AND SETTERS
	public LocalDateTime getFechaMatricula() {
		return fechaMatricula;
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
