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
@Table(name="distrito")
public class Distrito implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_distrito")
	private int id_distrito;
	
	@Column(name = "nombre")
	@Size(min = 5, max =20)
	private String nombre;
		
	public Distrito()
	{
		super();
	}
	public Distrito(String nombre)
	{
		super();
		this.nombre=nombre;
	}
	

	public int getId_distrito() {
		return id_distrito;
	}



	public void setId_distrito(int id_distrito) {
		this.id_distrito = id_distrito;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	
	
}
