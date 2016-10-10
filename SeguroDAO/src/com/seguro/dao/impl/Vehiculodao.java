package com.seguro.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seguro.dao.IVehiculodao;
import com.seguro.ds.Dbconnection;

import com.seguro.dto.Vehiculo;

public class Vehiculodao implements IVehiculodao{

	@Override
	public void create(Vehiculo o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_vehiculo(?,?,?,?,?,?,?,?)}";
		
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getModelo());
		cs.setString(3, o.getMarca());
		cs.setString(4, o.getPlaca());
		cs.setString(5, o.getTipoCaja());
		cs.setInt(6, o.getAnio());
		cs.setInt(7, o.getKilometraje());
		cs.setString(8, o.getEstado());

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException();
		}
		
	}

	@Override
	public void update(Vehiculo o) throws SQLException {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vehiculo get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehiculo> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String query="{call sp_list_vehiculo()}";
		List<Vehiculo> lista=new ArrayList<>();
		Connection cn=Dbconnection.getInstance();
		
		CallableStatement cs=cn.prepareCall(query);
		ResultSet rs=cs.executeQuery();
		while(rs.next()) lista.add(mapRow(rs));
		return lista;
	}

	@Override
	public Vehiculo mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Vehiculo v = new Vehiculo();
		
		v.setIdvehiculo(rs.getInt(1));
		
		v.setModelo(rs.getString(2));
		v.setMarca(rs.getString(3));
		v.setPlaca(rs.getString(4));
		v.setTipoCaja(rs.getString(5));
		v.setAnio(rs.getInt(6));
		v.setKilometraje(rs.getInt(7));
		v.setAnio(rs.getInt(8));
		
		return v;
	}

	@Override
	public List<Vehiculo> listarVehiculos(String marca) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_list_vehiculo()}";
		List<Vehiculo> lista = new ArrayList<>();
		
		Connection cn = Dbconnection.getInstance();
		
		CallableStatement cs = cn.prepareCall(query);
		ResultSet rs = cs.executeQuery();
		while(rs.next()){
			lista.add(mapRow(rs));
		}
		return lista;
	}
	

}
