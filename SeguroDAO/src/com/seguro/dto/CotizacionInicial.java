package com.seguro.dto;

public class CotizacionInicial {
	private int idcotizacion;
	private Vehiculo vehiculo;
	private float cotizacionInicial;
	
	
	public int getIdcotizacion() {
		return idcotizacion;
	}
	public void setIdcotizacion(int idcotizacion) {
		this.idcotizacion = idcotizacion;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public float getCotizacionInicial() {
		return cotizacionInicial;
	}
	public void setCotizacionInicial(float cotizacionInicial) {
		this.cotizacionInicial = cotizacionInicial;
	}
	
	

}
