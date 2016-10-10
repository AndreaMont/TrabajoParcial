package com.seguro.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seguro.dao.ICotizaciondao;
import com.seguro.ds.Dbconnection;
import com.seguro.dto.CotizacionInicial;
import com.seguro.dto.Vehiculo;

public class Cotizaciondao implements ICotizaciondao {

	@Override
	public void create(CotizacionInicial o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_cotizacionInicial(?,?,?)}";
		
		Connection cn = Dbconnection.getInstance();
		//cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(2, o.getVehiculo().getIdvehiculo());
		cs.setFloat(3, o.getCotizacionInicial());
		
		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException();
		}
		
	}

	@Override
	public void update(CotizacionInicial o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CotizacionInicial get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CotizacionInicial> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CotizacionInicial mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		CotizacionInicial ci = new CotizacionInicial();
		Vehiculo v = new Vehiculo();
		
		ci.setIdcotizacion(rs.getInt(1));
		v.setMarca(rs.getString(2));
		v.setModelo(rs.getString(3));
		v.setPlaca(rs.getString(4));
		ci.setCotizacionInicial(rs.getFloat(5));
		
		return ci;
	}

	@Override
	public List<CotizacionInicial> listarCotizacionInicial(float cotizacionInicial) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_list_cotizacionInicial()}";
		List<CotizacionInicial> lista = new ArrayList<>();
		
		Connection cn = Dbconnection.getInstance();
		
		CallableStatement cs = cn.prepareCall(query);
		ResultSet rs = cs.executeQuery();
		while(rs.next()){
			lista.add(mapRow(rs));
		}
		return lista;
	}

}
