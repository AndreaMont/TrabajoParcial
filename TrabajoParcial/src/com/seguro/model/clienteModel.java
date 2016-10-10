package com.seguro.model;

import java.sql.SQLException;
import java.util.List;

import com.seguro.dao.IClientedao;
import com.seguro.dto.Cliente;
import com.seguro.factory.Factory;

public class clienteModel {
	
	private IClientedao cdao = null;
	public clienteModel() {
		// TODO Auto-generated constructor stub
		cdao=Factory.getInstance().getClientedao();
	}
	
	public Cliente inicioSesion (String usuario, String contrasenia) throws SQLException{
		Cliente c = cdao.autentica(usuario, contrasenia);
		return c;
	}
	
	public void registrarCliente (Cliente c) throws SQLException{
		cdao.create(c);
	}
	public void eliminarCliente (int id) throws SQLException{
		cdao.delete(id);
	}
	public void updateCliente (Cliente clie) throws SQLException{
		cdao.update(clie);
	}
	public List<Cliente> listarClientes() throws SQLException{
		return cdao.getAll();
	}

}
