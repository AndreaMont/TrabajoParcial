package com.lab.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lab.entities.TipoMedicamento;

@Repository
@Transactional
public interface TipoMedicamentoRepository extends CrudRepository<TipoMedicamento, Integer> {
	
	List<TipoMedicamento> findByTipo(String tipo);

}
