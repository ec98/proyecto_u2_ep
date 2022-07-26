package com.uce.edu.demo.repository.modelo.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "autor2")
public class Autor2 {

	@Id
	@Column(name = "auto_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_id_seq")
	@SequenceGenerator(name = "auto_id_seq", sequenceName = "auto_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "auto_nombre")
	private String nombre;

	@OneToMany(mappedBy = "autores")
	private List<Libro2> libros;

	@Override
	public String toString() {
		return "Autor2 [id=" + id + ", nombre=" + nombre + ", libros=" + libros + "]";
	}

	// GETTERS AND SETTERS
	public Integer getId() {
		return id;
	}

	public List<Libro2> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro2> libros) {
		this.libros = libros;
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

}
