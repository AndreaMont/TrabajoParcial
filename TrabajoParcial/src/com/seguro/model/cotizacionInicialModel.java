package com.seguro.model;

import java.sql.SQLException;

import com.seguro.dao.ICotizaciondao;
import com.seguro.dto.CotizacionInicial;
import com.seguro.factory.Factory;

public class cotizacionInicialModel {

	public ICotizaciondao idao=null;
	public cotizacionInicialModel() {
		// TODO Auto-generated constructor stub
		idao=Factory.getInstance().getCotizaciondao();
	}
	public void registrarCotizacionInicial (CotizacionInicial ci) throws SQLException{
		idao.create(ci);
	}
	public void eliminarCotizacionInicial  (int id) throws SQLException{
		idao.delete(id);
	}
	public void updateCotizacionInicial (CotizacionInicial ci) throws SQLException{
		idao.update(ci);
	}
}
