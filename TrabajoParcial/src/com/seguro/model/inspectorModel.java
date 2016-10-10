package com.seguro.model;

import java.sql.SQLException;

import com.seguro.dao.IInspectordao;
import com.seguro.dto.Inspector;
import com.seguro.factory.Factory;

public class inspectorModel {
	public IInspectordao idao = null;
	
	public inspectorModel() {
		// TODO Auto-generated constructor stub
		idao = Factory.getInstance().getInspectordao();
	}
	public Inspector inicioSesion (String usuario, String contrasenia) throws SQLException{
		Inspector i = idao.autentica(usuario, contrasenia);
		return i;
	}
	
	public void registrarInspector (Inspector i) throws SQLException{
		idao.create(i);
	}
	public void deleteInspector (int id) throws SQLException{
		idao.delete(id);
	}
	

}
