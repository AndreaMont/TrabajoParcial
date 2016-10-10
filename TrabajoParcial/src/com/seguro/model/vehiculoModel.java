package com.seguro.model;

import java.sql.SQLException;

import com.seguro.dao.IVehiculodao;
import com.seguro.dao.impl.Vehiculodao;
import com.seguro.dto.Vehiculo;
import com.seguro.factory.Factory;

public class vehiculoModel {
public IVehiculodao vdao=null;

public vehiculoModel() {
	// TODO Auto-generated constructor stub
	vdao=Factory.getInstance().getVehiculodao();
}
public void registrarVehiculo (Vehiculo v) throws SQLException{
	vdao.create(v);
}
public void eliminarVehiculo (int id) throws SQLException{
	vdao.delete(id);
}
public void updateVehiculo (Vehiculo vehi) throws SQLException{
	vdao.update(vehi);
}
	
}
