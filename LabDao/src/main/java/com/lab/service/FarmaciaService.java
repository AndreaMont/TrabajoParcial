package com.lab.service;

import com.lab.entities.Farmacia;

public interface FarmaciaService {
	
	Farmacia saveFarmacia(Farmacia a);
	
	Iterable<Farmacia> listAllFarmacia();
	
	Iterable<Farmacia> getByNamedistrito(String distrito);
	
	void deleteFarmacia(int id);
	
	Farmacia getFarmaciaById (int id);

}
