package com.lab.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Farmacia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idFarmacia;
	
	@Size(min = 12)
	private int ruc;
	
	@Column(name = "nombre")
	@Size(min = 5, max = 20)
	private String nombre;
	
	@Size(min = 9)
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

	public int getIdFarmacia() {
		return idFarmacia;
	}

	public void setIdFarmacia(int idFarmacia) {
		this.idFarmacia = idFarmacia;
	}

	public int getRuc() {
		return ruc;
	}

	public void setRuc(int ruc) {
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