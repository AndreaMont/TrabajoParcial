package com.lab.service;

import com.lab.entities.Distrito;

public interface DistritoService {

	
	Iterable<Distrito> listAllDistritos();
	
	Distrito getDistritoById(int id);
	
	Distrito saveDistrito (Distrito distrito);
	
	void deleteDistrito(int id);
	
	Iterable<Distrito> getDistritoByNombre(String nombre);
	
	
}
