package com.seguro.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.seguro.dao.IPolizadao;
import com.seguro.ds.Dbconnection;
import com.seguro.dto.CotizacionFinal;
import com.seguro.dto.Poliza;

public class Polizadao implements IPolizadao {

	@Override
	public void create(Poliza o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_poliza(?,?,?,?,?)}";
		Connection cn = Dbconnection.getInstance();
		//cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(2, o.getCotizacionFinal().getIdcotizacionFinal());
		//cs.setDate(3, o.getFechaEnvio());
		cs.setFloat(4, o.getMonto());
		cs.setString(5, o.getT_documento());
		
		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException();
		}
		
	}

	@Override
	public void update(Poliza o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Poliza get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Poliza> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Poliza mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Poliza p = new Poliza();
		CotizacionFinal cf = new CotizacionFinal();
		
		p.setIdpoliza(rs.getInt(1));
		cf.setIdcotizacionFinal(rs.getInt(2));
		p.setFechaEnvio(rs.getDate(3));
		p.setMonto(rs.getFloat(4));
		
		return p;
	}

	@Override
	public List<Poliza> listarPoliza(int cotizacionFinal, Date fecha, float monto) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_list_poliza()}";
		List<Poliza> lista = new ArrayList<>();
		
		Connection cn = Dbconnection.getInstance();
		
		CallableStatement cs = cn.prepareCall(query);
		ResultSet rs = cs.executeQuery();
		
		while(rs.next()){
			lista.add(mapRow(rs));
		}
		
		return lista;
	}

}
