package com.lab.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
public class Medicamento {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMedicamento;
	
	@Column(name = "nombre")
	@Size(min = 5, max = 60)
	private String nombre;
	
	private String fCreacion;
	
	private String fVencimiento;
	
	@Column(name = "composicion")
	@Size(min = 5, max = 255)
	private String composicion;
	
	@Column(name = "precioUnitario")
	@Digits(integer = 10, fraction = 2)
	private Double precioUntario;
	
	@ManyToOne
	@JoinColumn(name = "id_tipoMedicamento")
	private TipoMedicamento tipoMedicamento;
	
	public Medicamento(){
		super();
	}

	public int getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getfCreacion() {
		return fCreacion;
	}

	public void setfCreacion(String fCreacion) {
		this.fCreacion = fCreacion;
	}

	public String getfVencimiento() {
		return fVencimiento;
	}

	public void setfVencimiento(String fVencimiento) {
		this.fVencimiento = fVencimiento;
	}

	public String getComposicion() {
		return composicion;
	}

	public void setComposicion(String composicion) {
		this.composicion = composicion;
	}

	public Double getPrecioUntario() {
		return precioUntario;
	}

	public void setPrecioUntario(Double precioUntario) {
		this.precioUntario = precioUntario;
	}

	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}

	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}
	
	
	
	
	

}
