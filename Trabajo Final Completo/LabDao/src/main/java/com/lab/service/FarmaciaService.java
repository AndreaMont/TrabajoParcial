package com.lab.service;

import com.lab.entities.Farmacia;

public interface FarmaciaService {
	
	Farmacia saveFarmacia(Farmacia farmacia);
	
	Iterable<Farmacia> listAllFarmacia();
	
	Iterable<Farmacia> getFarmaciaByNombre(String nombre);
	
	void deleteFarmacia(int id);
	
	Farmacia getFarmaciaById (int id);
	
	Iterable<Farmacia> getFarmaciaByDistrito(int id);

}
