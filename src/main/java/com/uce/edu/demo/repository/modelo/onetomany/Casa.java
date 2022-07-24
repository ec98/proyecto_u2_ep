package com.uce.edu.demo.repository.modelo.onetomany;

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
@Table(name = "Casa")
public class Casa {

	@Id
	@Column(name = "casa_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "casa_id_seq")
	@SequenceGenerator(name = "casa_id_seq", sequenceName = "casa_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "casa_numero")
	private String numero; // numero de casa

	@Column(name = "casa_costo")
	private BigDecimal costo;

	@Column(name = "casa_pisos")
	private String pisos;

	// TABLA SECUNDARY
	@ManyToOne
	@JoinColumn(name = "casa_id_conjunto")
	private Conjunto conjunto;

	@Override
	public String toString() {
		return "Casa [numero=" + numero + ", costo=" + costo + ", pisos=" + pisos + "]";
	}

	// GETTERS AND SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public String getPisos() {
		return pisos;
	}

	public void setPisos(String pisos) {
		this.pisos = pisos;
	}

	public Conjunto getConjunto() {
		return conjunto;
	}

	public void setConjunto(Conjunto conjunto) {
		this.conjunto = conjunto;
	}

}
