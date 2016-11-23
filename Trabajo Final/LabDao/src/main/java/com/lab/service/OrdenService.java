package com.lab.service;


import com.lab.entities.Orden;

public interface OrdenService {
	
	Orden saveOrden(Orden orden);
	
	Iterable<Orden> listAllOrden();
	
	void deleteOrden(int id_orden);
	
	Orden getOrdenById(int id);
	
	

	
	Iterable<Orden> findByFechaOrden(String fo1,String fo2);
	
	Iterable<Orden> getOrdenByFarmacia(int id);

	Iterable<Orden> getFarmaciaOrderByMontoTotalDESC();
	
	int countOrdenByFarmacia();
	
}
