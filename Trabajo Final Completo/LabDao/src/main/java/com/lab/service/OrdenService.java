package com.lab.service;


import java.util.Date;

import com.lab.entities.Orden;

public interface OrdenService {
	
	Orden saveOrden(Orden orden);
	
	Iterable<Orden> listAllOrden();
	
	void deleteOrden(int id_orden);
	
	Orden getOrdenById(int id);
	
	

	
	Iterable<Orden> findByF_ordenBetween(String date1,String date2);
	
	Iterable<Orden> getOrdenByFarmacia(int id);

	Iterable<Orden> getFarmaciaOrderByMontoTotalDESC(int itd);
	
	int countOrdenByFarmacia(int id);
	
}
