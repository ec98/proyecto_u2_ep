package com.uce.edu.demo.prueba.modelo.repository;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

	@Id
	@Column(name = "vehi_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehi_id_seq")
	@SequenceGenerator(name = "vehi_id_seq", sequenceName = "vehi_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "vehi_marca")
	private String marca;

	@Column(name = "vehi_tipo")
	private String tipo;

	@Column(name = "vehi_placa")
	private String placa;

	@Column(name = "vehi_precio")
	private BigDecimal precio;

	@ManyToOne
	@JoinColumn(name = "vehi_id_matricula")
	private Matricula matricula;

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", tipo=" + tipo + ", placa=" + placa + ", precio=" + precio
				+ ", matricula=" + matricula + "]";
	}

	// GETTERS AND SETTERS
	public String getMarca() {
		return marca;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}
