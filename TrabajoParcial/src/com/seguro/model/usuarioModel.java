package com.seguro.model;

import java.sql.SQLException;

import com.seguro.dao.IUsuariodao;
import com.seguro.dto.Usuario;
import com.seguro.factory.Factory;

public class usuarioModel {
	
	public IUsuariodao udao = null;
	public usuarioModel() {
		// TODO Auto-generated constructor stub
		udao=Factory.getInstance().getUsuariodao();
	}
	
	public Usuario inicioSesion(String correo,String password) throws SQLException{
		Usuario u=udao.autentica(correo, password);
		return u;
	}
	
	public void registrarUsuario(Usuario u)throws SQLException{
		udao.create(u);
	}

}
