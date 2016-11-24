package com.lab.service;

import com.lab.entities.Medicamento;

public interface MedicamentoService {
	
	Iterable<Medicamento> listAllMedicamentos();
	
	Medicamento saveMedicamento(Medicamento medicamento);
	
	void deleteMedicamento(int id_medicamento);
	
	Iterable<Medicamento> getMedicamentoByNombre(String nombre);
	
	Medicamento getMedicamentoById(int id);
		
	Iterable<Medicamento> getMedicamentoByTipoMedicamento(int id);

	int countMedicamentoByTipo(int id);
}
