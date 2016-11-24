package com.lab.service;

import com.lab.entities.TipoMedicamento;

public interface TipoMedicamentoService {
	
	Iterable<TipoMedicamento> listAllTipoMedicamentos();
	
	TipoMedicamento getTipoMedicamentoById(int id);
	
	TipoMedicamento saveTipoMedicamento(TipoMedicamento tipoMedicamento);
	
	void deleteTipoMedicamento(int id);
	
	Iterable<TipoMedicamento> getTipoMedicamentoByName(String tipo);

}
