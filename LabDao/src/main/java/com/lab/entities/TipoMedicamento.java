package com.lab.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class TipoMedicamento {
		
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
	
	public TipoMedicamento(String nombre) {
		super();
		this.tipo = nombre;
	}


	public int getIdTipoMedicamento() {
		return id_tipomedicamento;
	}

	public void setIdTipoMedicamento(int idTipoMedicamento) {
		this.id_tipomedicamento = idTipoMedicamento;
	}

	public String getNombre() {
		return tipo;
	}

	public void setNombre(String nombre) {
		this.tipo = nombre;
	}
	

}
