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
	@Column(name = "id_tipoMedicamento")
	private int idTipoMedicamento;
	
	@Column(name = "nombre")
	@Size(min = 5, max = 20)
	private String nombre;
	
	public TipoMedicamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TipoMedicamento(String nombre) {
		super();
		this.nombre = nombre;
	}


	public int getIdTipoMedicamento() {
		return idTipoMedicamento;
	}

	public void setIdTipoMedicamento(int idTipoMedicamento) {
		this.idTipoMedicamento = idTipoMedicamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
