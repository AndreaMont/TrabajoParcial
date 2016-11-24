package com.lab.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lab.entities.Orden;
import com.lab.repository.OrdenRepository;

@Service
public class OrdenServiceImpl implements OrdenService {

	@Autowired
	private OrdenRepository ordenRepository;
	
	@Override
	public Orden saveOrden(Orden orden) {
		// TODO Auto-generated method stub
		return ordenRepository.save(orden);
	}

	@Override
	public Iterable<Orden> listAllOrden() {
		// TODO Auto-generated method stub
		return ordenRepository.findAll();
	}

	@Override
	public void deleteOrden(int id_orden) {
		// TODO Auto-generated method stub
		ordenRepository.delete(id_orden);
	}

	@Override
	public Orden getOrdenById(int id) {
		// TODO Auto-generated method stub
		return ordenRepository.findOne(id);
	}

	

	

	@Override
	public Iterable<Orden> findByF_ordenBetween(String date1, String date2) {
		// TODO Auto-generated method stub
		return ordenRepository.findByF_ordenBetween(date1, date2);
	}
	
	
	

	@Override
	public Iterable<Orden> getOrdenByFarmacia(int id) {
		// TODO Auto-generated method stub
		return ordenRepository.findByCodeFarmacia(id);
	}

	@Override
	public Iterable<Orden> getFarmaciaOrderByMontoTotalDESC(int id) {
		// TODO Auto-generated method stub
		return ordenRepository.findByMontototalDESC(id);
	}
	
	@Override
	public int countOrdenByFarmacia(int id) {
		// TODO Auto-generated method stub
		return ordenRepository.countOrdenFarmacia(id);
	}



}
