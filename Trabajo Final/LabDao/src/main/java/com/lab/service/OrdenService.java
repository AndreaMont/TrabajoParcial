package com.lab.service;

import java.util.Date;

import com.lab.entities.Orden;

public interface OrdenService {
	
	Orden saveOrden(Orden o);
	
	Iterable<Orden> listAllOrden();
	
	void deleteOrden(int id_orden);
	
	Orden getOrdenById(int id);
	
	
	/*Iterable<Orden> findAllByFarmaciaByMontototalDesc(int id);
	*/
	Iterable<Orden> findByFechaEnvio(String fe1,String fe2);
	
	
	Iterable<Orden> findByFechaOrden(String fo1,String fo2);
/*
	int countOrdenByFarmacia(int id);
*/
	double calcularImporteTotal(Orden o);
	
	
	Iterable<Orden> getOrdenByFarmacia(int id);

	
}
