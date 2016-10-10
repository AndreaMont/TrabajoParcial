package com.seguro.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seguro.dao.IClientedao;
import com.seguro.ds.Dbconnection;
import com.seguro.dto.Cliente;

public class Clientedao implements IClientedao{

	@Override
	public void create(Cliente o) throws SQLException {
		// TODO Auto-generated method stub
		
		String insert = "{call sp_insert_cliente(?,?,?,?,?,?,?,?)}";
		
		Connection cn = Dbconnection.getInstance();
		
		
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombre());
		cs.setString(3, o.getApellido());
		cs.setInt(4, o.getDni());
		cs.setInt(5, o.getTelefono());
		cs.setString(6, o.getFechaNacimiento());
		cs.setString(7, o.getUsuario());
		cs.setString(8, o.getContrasenia());
		

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException(estado);
		}
	}

	@Override
	public void update(Cliente o) throws SQLException {
		// TODO Auto-generated method stub
		
		String insert = "{call sp_update_cliente(?,?,?,?,?,?,?,?,?)}";
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(2, o.getIdcliente());
		cs.setString(3, o.getNombre());
		cs.setString( 4,o.getApellido());
		cs.setInt(5,o.getDni());
		cs.setInt(6, o.getTelefono());
		cs.setString(7, o.getFechaNacimiento());
		cs.setString(8, o.getUsuario());
		cs.setString(9, o.getContrasenia());

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException();
		}

		
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		
		String insert = "{call sp_delete_cliente(?,?)}";
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(2, id);

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException();
		}

		
	}

	@Override
	public Cliente get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String query="{call sp_list_cliente()}";
		List<Cliente> lista=new ArrayList<>();
		Connection cn=Dbconnection.getInstance();
		
		CallableStatement cs=cn.prepareCall(query);
		ResultSet rs=cs.executeQuery();
		while(rs.next()) lista.add(mapRow(rs));
		return lista;
	}

	@Override
	public Cliente mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();
		
		c.setIdcliente(rs.getInt(1));
		c.setNombre(rs.getString(2));
		c.setApellido(rs.getString(3));
		c.setDni(rs.getInt(4));
		c.setTelefono(rs.getInt(5));
		c.setFechaNacimiento(rs.getString(6));	
		c.setUsuario(rs.getString(7));
		c.setContrasenia(rs.getString(8));
		return c;
	}

	@Override
	public Cliente autentica(String usuario, String contrasenia) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_autentica_cliente()}";
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
