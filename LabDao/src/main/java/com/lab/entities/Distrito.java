package com.lab.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class Distrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idDistrito")
	private int idDistrito;
	
	@Column(name = "distrito")
	@Size(min = 5, max =20)
	public String distrito;
		
	public Distrito()
	{
		super();
	}
	
	public int getId() {
		return idDistrito;
	}

	
	
	public void setId(int id) {
		this.idDistrito = id;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public Distrito(String distrito)
	{
		super();
		this.distrito=distrito;
	}
	
}
