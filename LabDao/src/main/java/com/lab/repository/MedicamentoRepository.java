package com.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lab.entities.Medicamento;

@Repository
@Transactional
public interface MedicamentoRepository extends CrudRepository<Medicamento, Integer> {
	
	List<Medicamento> findByNombre (String nombre);
	
	@Query("SELECT m FROM medicamento where m.tipoMedicamento.id_tipomedicamento = :tipomedicamentoId")
	List<Medicamento> findByTipoMedicamento(@Param("tipomedicamentoId") int tipomedicamentoId);
		
}
