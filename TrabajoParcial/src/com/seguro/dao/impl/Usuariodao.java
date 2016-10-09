package com.seguro.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.seguro.dao.IUsuariodao;
import com.seguro.ds.Dbconnection;
import com.seguro.dto.Usuario;

public class Usuariodao implements IUsuariodao{

	@Override
	public void create(Usuario o) throws SQLException {
		// TODO Auto-generated method stub
		
String insert = "{call sp_insert_usuario(?,?,?,?,?)}";
		
		Connection cn = Dbconnection.getInstance();
		
		
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getApellidos());
		cs.setString(3, o.getNombres());
		cs.setString(4, o.getCorreo());
		cs.setString(5, o.getPassword());
		

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException(estado);
		}
		
	}

	@Override
	public void update(Usuario o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
		u.setId(rs.getInt(1));
		u.setApellidos(rs.getString(2));
		u.setNombres(rs.getString(3));
		u.setCorreo(rs.getString(4));
		u.setPassword(rs.getString(5));
		u.setTipoUsuario(rs.getString(6));

		return u;
	}

	@Override
	public Usuario autentica(String correo, String password) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_autentica_usuario(?,?)}";

		Connection cn = Dbconnection.getInstance();
		

		CallableStatement cs = cn.prepareCall(query);
		cs.setString(1, correo);
		cs.setString(2, password);

		ResultSet rs = cs.executeQuery();
		if (rs.next()) {
			mapRow(rs);
		}

		return mapRow(rs);

	}

	
}
