package com.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.entities.Medicamento;
import com.lab.repository.MedicamentoRepository;

@Service
public class MedicamentoServiceImpl implements MedicamentoService{

	@Autowired
	private MedicamentoRepository medicamentoRepository;
	
	@Override
	public Iterable<Medicamento> listAllMedicamentos() {
		// TODO Auto-generated method stub
		return medicamentoRepository.findAll();
	}

	@Override
	public Medicamento getMedicamentoById(int id) {
		// TODO Auto-generated method stub
		return medicamentoRepository.findOne(id);
	}

	@Override
	public Medicamento saveMedicamento(Medicamento medicamento) {
		// TODO Auto-generated method stub
		return medicamentoRepository.save(medicamento);
	}

	@Override
	public void deleteMedicamento(int id) {
		// TODO Auto-generated method stub
		medicamentoRepository.delete(id);
	}

	@Override
	public Iterable<Medicamento> getMedicamentoByName(String nombre) {
		// TODO Auto-generated method stub
		return medicamentoRepository.findByNombre(nombre);
	}

	@Override
	public Iterable<Medicamento> getMedicamentoByTipoMedicamento(int id) {
		// TODO Auto-generated method stub
		return medicamentoRepository.findByCodeTipoMedicamento(id);
	}

}
