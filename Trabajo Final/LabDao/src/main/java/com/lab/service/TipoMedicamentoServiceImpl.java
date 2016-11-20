package com.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.entities.TipoMedicamento;
import com.lab.repository.TipoMedicamentoRepository;

@Service
public class TipoMedicamentoServiceImpl implements TipoMedicamentoService {
	
	@Autowired
	private TipoMedicamentoRepository tipoMedicamentoRepository;

	@Override
	public Iterable<TipoMedicamento> listAllTipoMedicamentos() {
		// TODO Auto-generated method stub
		return tipoMedicamentoRepository.findAll();
	}

	@Override
	public TipoMedicamento getTipoMedicamentoById(int id) {
		// TODO Auto-generated method stub
		return tipoMedicamentoRepository.findOne(id);
	}

	@Override
	public TipoMedicamento saveTipoMedicamento(TipoMedicamento tipoMedicamento) {
		// TODO Auto-generated method stub
		return tipoMedicamentoRepository.save(tipoMedicamento);
	}

	@Override
	public void deleteTipoMedicamento(int id) {
		// TODO Auto-generated method stub
		tipoMedicamentoRepository.delete(id);
	}

	@Override
	public Iterable<TipoMedicamento> getTipoMedicamentoByName(String tipo) {
		// TODO Auto-generated method stub
		return tipoMedicamentoRepository.findByTipo(tipo);
	}

	
}
