package com.seguro.model;

import java.sql.SQLException;

import com.seguro.dao.ICitadao;
import com.seguro.dto.Cita;
import com.seguro.factory.Factory;

public class citaModel {
	public ICitadao cdao = null;
	
	public citaModel() {
		// TODO Auto-generated constructor stub
		cdao = Factory.getInstance().getCitadao();
		
	}
	public void registrarCita (Cita c) throws SQLException{
		cdao.create(c);
	}
	public void eliminarCita (int id) throws SQLException{
		cdao.delete(id);
	}
	public void updateCita (Cita c) throws SQLException{
		cdao.update(c);
	}

}
