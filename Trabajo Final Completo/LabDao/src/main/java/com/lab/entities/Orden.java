package com.lab.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
@Entity
public class Orden {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_orden;
	
	@Column(name="f_orden")
	private String f_orden;
	
	@Column(name="f_envio")
	private String f_envio;
	
	@Column(name="direccion")
	@Size(min=5,max=50)
	private String direccion;
	
	@Column(name="cantidad")
	@Min(1)
	@Max(1000)
	private int cantidad;
	
	
	@Column(name="montototal")
	private double montototal;

	@ManyToOne
	@JoinColumn(name = "id_farmacia")
	private Farmacia farmacia;

	@ManyToOne
	@JoinColumn(name = "id_medicamento")
	private Medicamento medicamento;

	
	
	public Orden() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int getId_orden() {
		return id_orden;
	}

	public void setId_orden(int id_orden) {
		this.id_orden = id_orden;
	}


	/*
	public Date getF_orden() {
		return f_orden;
	}


	public void setF_orden(Date f_orden) {
		this.f_orden = f_orden;
	}


	public Date getF_envio() {
		return f_envio;
	}

	

	public void setF_envio(Date f_envio) {
		this.f_envio = f_envio;
	}*/


	public String getF_orden() {
		return f_orden;
	}


	public void setF_orden(String f_orden) {
		this.f_orden = f_orden;
	}


	public String getF_envio() {
		return f_envio;
	}


	public void setF_envio(String f_envio) {
		this.f_envio = f_envio;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getMontototal() {
		return montototal;
	}

	public void setMontototal(double montototal) {
		this.montototal = montototal;
	}

	public Farmacia getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	
}
