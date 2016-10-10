package com.seguro.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.seguro.dao.IInspectordao;
import com.seguro.ds.Dbconnection;
import com.seguro.dto.Inspector;

public class Inspectordao implements IInspectordao {

	@Override
	public void create(Inspector o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_inspector(?,?,?,?,?,?)}";
		
		Connection cn = Dbconnection.getInstance();
		
		
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombre());
		cs.setString(3, o.getApellido());
		cs.setInt(4, o.getDni());
		cs.setString(5, o.getUsuario());
		cs.setString(6, o.getContrasenia());
		
		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException(estado);
		}
		
	}

	@Override
	public void update(Inspector o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Inspector get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inspector> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inspector mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Inspector i = new Inspector();
		
		i.setIdinspector(rs.getInt(1));
		i.setNombre(rs.getString(2));
		i.setApellido(rs.getString(3));
		i.setDni(rs.getInt(4));
		i.setUsuario(rs.getString(7));
		i.setContrasenia(rs.getString(8));
		
		return i;
	}

	@Override
	public Inspector autentica(String usuario, String contrasenia) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_autentica_inspector}";
		Connection cn = Dbconnection.getInstance();
		
		CallableStatement cs = cn.prepareCall(query);
		cs.setString(1, usuario);
		cs.setString(2, contrasenia);
		
		ResultSet rs = cs.executeQuery();
		if(rs.next()){
			mapRow(rs);
		}
		
		return mapRow(rs);
	}
	

}
