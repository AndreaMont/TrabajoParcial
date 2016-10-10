package com.seguro.dto;

import java.util.Date;

public class CotizacionFinal {
	private int idcotizacionFinal;
	private Cita cita;
	private Date fecha;
	private int f_aprobado;
	
	
	public int getIdcotizacionFinal() {
		return idcotizacionFinal;
	}
	public void setIdcotizacionFinal(int idcotizacionFinal) {
		this.idcotizacionFinal = idcotizacionFinal;
	}
	public Cita getCita() {
		return cita;
	}
	public void setCita(Cita cita) {
		this.cita = cita;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getF_aprobado() {
		return f_aprobado;
	}
	public void setF_aprobado(int f_aprobado) {
		this.f_aprobado = f_aprobado;
	}
	
		

}
