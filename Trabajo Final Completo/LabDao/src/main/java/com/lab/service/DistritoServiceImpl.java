package com.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.entities.Distrito;
import com.lab.repository.DistritoRepository;

@Service
public class DistritoServiceImpl implements DistritoService {

	@Autowired
	private DistritoRepository distritoRepository;
	
	@Override
	public Iterable<Distrito> listAllDistritos() {
		// TODO Auto-generated method stub
		return distritoRepository.findAll();
	}

	@Override
	public Distrito getDistritoById(int id) {
		// TODO Auto-generated method stub
		return distritoRepository.findOne(id);
	}

	@Override
	public Distrito saveDistrito(Distrito distrito) {
		// TODO Auto-generated method stub
		return distritoRepository.save(distrito);
	}

	@Override
	public void deleteDistrito(int id) {
		// TODO Auto-generated method stub
		distritoRepository.delete(id);
		
	}

	@Override
	public Iterable<Distrito> getDistritoByNombre(String nombre) {
		// TODO Auto-generated method stub
		return distritoRepository.findByNombre(nombre);
	}

}
