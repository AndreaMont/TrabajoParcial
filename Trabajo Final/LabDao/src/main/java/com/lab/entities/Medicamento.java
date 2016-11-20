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
	
	@Column(name = "f_creacion")
	private String f_creacion;
	
	@Column(name = "f_vencimiento")
	private String f_vencimiento;
	
	@Column(name = "composicion")
	@Size(min = 5, max = 255)
	private String composicion;
	
	@Column(name = "preciounitario")
	@Digits(integer = 8, fraction = 2)
	private Double preciounitario;
	
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

	public TipoMedicamento getTipoMedicamento() {
		return tipomedicamento;
	}

	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipomedicamento = tipoMedicamento;
	}

	public String getF_creacion() {
		return f_creacion;
	}

	public void setF_creacion(String f_creacion) {
		this.f_creacion = f_creacion;
	}

	public Double getPreciounitario() {
		return preciounitario;
	}

	public void setPreciounitario(Double preciounitario) {
		this.preciounitario = preciounitario;
	}

	

	public TipoMedicamento getTipomedicamento() {
		return tipomedicamento;
	}

	public void setTipomedicamento(TipoMedicamento tipomedicamento) {
		this.tipomedicamento = tipomedicamento;
	}
	

	
	}
