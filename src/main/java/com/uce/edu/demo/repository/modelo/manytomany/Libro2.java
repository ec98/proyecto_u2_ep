package com.uce.edu.demo.repository.modelo.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "libro2")
public class Libro2 {

	@Id
	@Column(name = "libr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libr_id_seq")
	@SequenceGenerator(name = "libr_id_seq", sequenceName = "libr_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "libr_titulo")
	private String titulo;

	@Column(name = "libr_cantidad_paginas")
	private Integer cantidadPaginas;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "libro2_autor2", joinColumns = @JoinColumn(name = "liau_id_libro2"), inverseJoinColumns = @JoinColumn(name = "liau_id_autor2"))
	private List<Autor2> autores;

	@Override
	public String toString() {
		return "Libro2 [id=" + id + ", titulo=" + titulo + ", cantidadPaginas=" + cantidadPaginas + ", autores="
				+ autores + "]";
	}

	// GETTERS AND SETTERS
	public Integer getId() {
		return id;
	}

	public List<Autor2> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor2> autores) {
		this.autores = autores;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(Integer cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}
}
