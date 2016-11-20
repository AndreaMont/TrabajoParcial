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
	public void deleteOrden(int id_orden) {
		// TODO Auto-generated method stub
		ordenRepository.delete(id_orden);
	}

	@Override
	public Orden getOrdenById(int id) {
		// TODO Auto-generated method stub
		return ordenRepository.findOne(id);
	}

	/*@Override
	public Iterable<Orden> findAllByFarmaciaByMontototalDesc(int id) {
		// TODO Auto-generated method stub
		return ordenRepository.findAllByFarmaciaOrderByMontototalDesc(id);
	}
*/
	@Override
	public Iterable<Orden> findByFechaEnvio(String fe1, String fe2) {
		// TODO Auto-generated method stub
		return ordenRepository.findByFechaEnvio(fe1, fe2);
	}

	@Override
	public Iterable<Orden> findByFechaOrden(String fo1, String fo2) {
		// TODO Auto-generated method stub
		return ordenRepository.findByFechaOrden(fo1, fo2);
	}
	
	/*
	public int countOrdenByFarmacia(int id) {
		// TODO Auto-generated method stub
		return ordenRepository.countOrdenFarmacia(id);
	}*/

	@Override
	public double calcularImporteTotal(Orden o) {
		// TODO Auto-generated method stub
		
		double importetotal=0.0;//importeTotal
		importetotal=o.getCantidad()*o.getMedicamento().getPreciounitario();
		return importetotal;
	}

	@Override
	public Iterable<Orden> getOrdenByFarmacia(int id) {
		// TODO Auto-generated method stub
		return ordenRepository.findByCodeFarmacia(id);
	}


}
