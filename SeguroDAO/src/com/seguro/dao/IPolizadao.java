package com.seguro.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.seguro.dto.Poliza;

public interface IPolizadao extends ICruddao<Poliza>, IRowmapper<Poliza> {
	
	List<Poliza> listarPoliza (int cotizacionFinal, Date fecha, float monto) throws SQLException;

}
