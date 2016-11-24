package com.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.entities.Farmacia;
import com.lab.repository.FarmaciaRepository;

@Service
public class FarmaciaServiceImpl implements FarmaciaService {

	@Autowired
	private FarmaciaRepository farmaciaRepository;
	
	@Override
	public Farmacia saveFarmacia(Farmacia farmacia) {
		// TODO Auto-generated method stub
		return farmaciaRepository.save(farmacia);
	}

	@Override
	public Iterable<Farmacia> listAllFarmacia() {
		// TODO Auto-generated method stub
		return farmaciaRepository.findAll();
	}

	

	@Override
	public void deleteFarmacia(int id) {
		// TODO Auto-generated method stub
		farmaciaRepository.delete(id);
	}

	@Override
	public Farmacia getFarmaciaById(int id) {
		// TODO Auto-generated method stub
		return farmaciaRepository.findOne(id);
	}

	@Override
	public Iterable<Farmacia> getFarmaciaByNombre(String nombre) {
		// TODO Auto-generated method stub
		return farmaciaRepository.findByNombre(nombre);
	}

	@Override
	public Iterable<Farmacia> getFarmaciaByDistrito(int id) {
		// TODO Auto-generated method stub
		return farmaciaRepository.findByCodeDistrito(id);
	}

}
