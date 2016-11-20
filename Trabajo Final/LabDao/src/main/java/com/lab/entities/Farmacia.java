package com.lab.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Farmacia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_farmacia;
	
	@Column(name = "ruc")
	@Size(min=11,max=11)
	private String ruc;
	
	@Column(name = "nombre")
	@Size(min = 5, max = 20)
	private String nombre;
	
	@Column(name = "telefono")
	@Min(100000000)
	@Max(999999999)
	private int telefono;
	
	@Column(name = "direccion")
	@Size(min = 5, max = 20)
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name = "id_distrito")
	private Distrito distrito;
	
	public Farmacia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId_farmacia() {
		return id_farmacia;
	}

	public void setId_farmacia(int id_farmacia) {
		this.id_farmacia = id_farmacia;
	}

	
	
	
	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}



	
}