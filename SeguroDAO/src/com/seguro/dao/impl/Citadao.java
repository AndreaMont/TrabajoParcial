package com.seguro.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seguro.dao.ICitadao;
import com.seguro.ds.Dbconnection;
import com.seguro.dto.Cita;
import com.seguro.dto.Cliente;
import com.seguro.dto.Inspector;

public class Citadao implements ICitadao{

	@Override
	public void create(Cita o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_cita(?,?,?,?,?)}";
		
		Connection cn = Dbconnection.getInstance();
		
		
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getInspector().getNombre());
		cs.setString(3, o.getCliente().getNombre());
		cs.setString(4, o.getDireccion());
		//cs.setDate(5, o.getFecha());
		
		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException(estado);
		}
	}

	@Override
	public void update(Cita o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cita get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cita> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cita mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Cita c = new Cita();
		Inspector i = new Inspector();
		Cliente cl = new Cliente();
		
		c.setIdcita(rs.getInt(1));
		i.setNombre(rs.getString(2));
		cl.setNombre(rs.getString(3));
		c.setDireccion(rs.getString(4));
		c.setFecha(rs.getDate(5));
		
		return c;
	}

	@Override
	public List<Cita> listarCitasCliente(Cliente o) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_list_cita()}";
		List<Cita> lista = new ArrayList<>();
		
		Connection cn = Dbconnection.getInstance();
		
		CallableStatement cs = cn.prepareCall(query);
		ResultSet rs = cs.executeQuery();
		while(rs.next()){
			
			lista.add(mapRow(rs));			
		}
		
		return lista;
	}

}
