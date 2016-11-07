package com.lab.service;

import com.lab.entities.Medicamento;

public interface MedicamentoService {
	
	Iterable<Medicamento> listAllMedicamentos();
	
	Medicamento getMedicamentoById(int id);
	
	Medicamento saveMedicamento(Medicamento medicamento);
	
	void deleteMedicamento(int id);
	
	Iterable<Medicamento> getMedicamentoByName(String nombre);
	
	Iterable<Medicamento> getMedicamentoByTipoMedicamento(int id);

}
