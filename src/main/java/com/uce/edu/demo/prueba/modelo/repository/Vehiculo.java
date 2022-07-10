package com.uce.edu.demo.prueba.modelo.repository;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

	@Column(name="marca")
	private String marca;

	@Column(name="tipo")
	private String tipo;

	@Id
	@Column(name="placa")
	private String placa;

	@Column(name="precio")
	private BigDecimal precio;

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", tipo=" + tipo + ", placa=" + placa + ", precio=" + precio + "]";
	}

	// GETTERS AND SETTERS
	public String getMarca() {
		return marca;
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
