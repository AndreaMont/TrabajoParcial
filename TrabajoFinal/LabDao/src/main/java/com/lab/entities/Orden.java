package com.lab.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class Orden {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idOrden;
	
	private String fOrden;
	
	private String fEnvio;
	
	@Column(name = "direccion")
	@Size(min = 5, max =20)
	private String direccion;
	
	@Size(min = 12)
	private int rucLab;
	
	
	private double importeTotal;
	
	private double igv;
	
	private double valorVentaNeta;
	
	private String condicionPago;
	
	private int ctaCorriente;
	
	private String banco;
	

}
