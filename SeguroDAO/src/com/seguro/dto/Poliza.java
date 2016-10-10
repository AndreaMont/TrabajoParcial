package com.seguro.dto;

import java.util.Date;

public class Poliza {
	private int idpoliza;
	private CotizacionFinal cotizacionFinal;
	private Date fechaEnvio;
	private float monto;
	private String t_documento;
	
	
	public int getIdpoliza() {
		return idpoliza;
	}
	public void setIdpoliza(int idpoliza) {
		this.idpoliza = idpoliza;
	}
	public CotizacionFinal getCotizacionFinal() {
		return cotizacionFinal;
	}
	public void setCotizacionFinal(CotizacionFinal cotizacionFinal) {
		this.cotizacionFinal = cotizacionFinal;
	}
	public Date getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getT_documento() {
		return t_documento;
	}
	public void setT_documento(String t_documento) {
		this.t_documento = t_documento;
	}
	

}
