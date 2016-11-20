package com.lab.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="tipomedicamento")
public class TipoMedicamento implements Serializable{
		
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipomedicamento")
	private int id_tipomedicamento;
	
	@Column(name = "tipo")
	@Size(min = 5, max = 45)
	private String tipo;
	
	public TipoMedicamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TipoMedicamento(String tipo) {
		super();
		this.tipo = tipo;
	}


	

	public int getId_tipomedicamento() {
		return id_tipomedicamento;
	}

	public void setId_tipomedicamento(int id_tipomedicamento) {
		this.id_tipomedicamento = id_tipomedicamento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	

}
