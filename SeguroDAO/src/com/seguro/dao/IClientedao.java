package com.seguro.dao;

import java.sql.SQLException;

import com.seguro.dto.Cliente;

public interface IClientedao extends ICruddao<Cliente>,IRowmapper<Cliente> {
	
	Cliente autentica(String usuario, String contrasenia)throws SQLException;

}
