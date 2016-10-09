package com.seguro.dao;

import java.sql.SQLException;

import com.seguro.dto.Usuario;

public interface IUsuariodao extends ICruddao<Usuario>,IRowmapper<Usuario>{
	
	Usuario autentica(String correo, String password)throws SQLException;

}
