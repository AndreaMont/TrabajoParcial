package com.seguro.dto;

public class Cita {
	
	private int idcita;
	private Inspector inspector;
	private Cliente cliente;
	private String direccion;
	private String fecha;
	
	
	public int getIdcita() {
		return idcita;
	}
	public void setIdcita(int idcita) {
		this.idcita = idcita;
	}
	public Inspector getInspector() {
		return inspector;
	}
	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	

}
