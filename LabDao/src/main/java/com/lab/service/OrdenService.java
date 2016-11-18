package com.lab.service;

import com.lab.entities.Orden;

public interface OrdenService {
	
	Orden saveOrden(Orden o);
	
	Iterable<Orden> listAllOrden();
	
	Iterable<Orden> findByFarmaciaOrderByMontototalDesc(int id);
	
	Iterable<Orden> findByPrecioVenta(double pv1,double pv2);
	
	int countOrdenByFarmacia(int id);

}
