package com.seguro.dao;

import java.sql.SQLException;

import com.seguro.dto.Inspector;

public interface IInspectordao extends ICruddao<Inspector>,IRowmapper<Inspector> {
	
	Inspector autentica(String usuario, String contrasenia)throws SQLException;

}
