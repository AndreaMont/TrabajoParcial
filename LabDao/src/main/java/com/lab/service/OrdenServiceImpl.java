package com.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.entities.Orden;
import com.lab.repository.OrdenRepository;

@Service
public class OrdenServiceImpl implements OrdenService {

	@Autowired
	private OrdenRepository ordenRepository;
	
	@Override
	public Orden saveOrden(Orden o) {
		// TODO Auto-generated method stub
		return ordenRepository.save(o);
	}

	@Override
	public Iterable<Orden> listAllOrden() {
		// TODO Auto-generated method stub
		return ordenRepository.findAll();
	}

	@Override
	public Iterable<Orden> findByFarmaciaOrderByMontototalDesc(int id) {
		// TODO Auto-generated method stub
		return ordenRepository.findByFarmaciaOrderByMontototalDesc(id);
	}

	@Override
	public Iterable<Orden> findByPrecioVenta(double pv1, double pv2) {
		// TODO Auto-generated method stub
		return ordenRepository.findByPrecioVenta(pv1, pv2);
	}

	@Override
	public int countOrdenByFarmacia(int id) {
		// TODO Auto-generated method stub
		return ordenRepository.countOrdenByFarmacia(id);
	}

}
