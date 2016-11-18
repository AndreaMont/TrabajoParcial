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
	public Farmacia saveFarmacia(Farmacia a) {
		// TODO Auto-generated method stub
		return farmaciaRepository.save(a);
	}

	@Override
	public Iterable<Farmacia> listAllFarmacia() {
		// TODO Auto-generated method stub
		return farmaciaRepository.findAll();
	}

	@Override
	public Iterable<Farmacia> getByNamedistrito(String distrito) {
		// TODO Auto-generated method stub
		return farmaciaRepository.findByNamedistrito(distrito);
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

}
