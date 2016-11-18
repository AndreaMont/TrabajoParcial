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
	private int id_medicamento;
	
	@Column(name = "nombre")
	@Size(min = 5, max = 60)
	private String nombre;
	
	@Column(name = "f_vreacion")
	private String f_vreacion;
	
	@Column(name = "f_vencimiento")
	private String f_vencimiento;
	
	@Column(name = "composicion")
	@Size(min = 5, max = 255)
	private String composicion;
	
	@Column(name = "preciounitario")
	@Digits(integer = 10, fraction = 2)
	private Double precioUntario;
	
	@ManyToOne
	@JoinColumn(name = "id_tipomedicamento")
	private TipoMedicamento tipomedicamento;
	
	public Medicamento(){
		super();
	}

	public int getId_medicamento() {
		return id_medicamento;
	}

	public void setId_medicamento(int id_medicamento) {
		this.id_medicamento = id_medicamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getF_vreacion() {
		return f_vreacion;
	}

	public void setF_vreacion(String f_vreacion) {
		this.f_vreacion = f_vreacion;
	}

	public String getF_vencimiento() {
		return f_vencimiento;
	}

	public void setF_vencimiento(String f_vencimiento) {
		this.f_vencimiento = f_vencimiento;
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
		return tipomedicamento;
	}

	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipomedicamento = tipoMedicamento;
	}

	
	}
