package com.seguro.dao;

import java.sql.SQLException;
import java.util.List;

import com.seguro.dto.Vehiculo;

public interface IVehiculodao extends ICruddao<Vehiculo>, IRowmapper<Vehiculo> {
	
	List<Vehiculo> listarVehiculos (String marca) throws SQLException;

}
