package com.uce.edu.demo.repository.modelo.onetomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Conjunto")
public class Conjunto {

	@Id
	@Column(name = "conj_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conj_id_seq")
	@SequenceGenerator(name = "conj_id_seq", sequenceName = "conj_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "conj_nombre")
	private String nombre;

	@Column(name = "conj_telefono")
	private String telefono;

	// TABLA PRINCIPAL
	@OneToMany(mappedBy = "conjunto")
	private List<Casa> casas;

	@Override
	public String toString() {
		return "Conjunto [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", casas=" + casas + "]";
	}

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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Casa> getCasas() {
		return casas;
	}

	public void setCasas(List<Casa> casas) {
		this.casas = casas;
	}

}
