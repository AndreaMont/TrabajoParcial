package com.seguro.model;

import java.sql.SQLException;

import com.seguro.dao.IPolizadao;
import com.seguro.dto.Poliza;
import com.seguro.factory.Factory;

public class polizaModel {
	public IPolizadao pdao = null;

	public polizaModel() {
		// TODO Auto-generated constructor stub
		pdao=Factory.getInstance().getPolizadao();
		
	}
	public void registrarPoliza (Poliza p) throws SQLException{
		pdao.create(p);
	}
	public void eliminarPoliza (int id) throws SQLException{
		pdao.delete(id);
	}
	public void updatePoliza (Poliza poli) throws SQLException{
		pdao.update(poli);
	}
}
