package com.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lab.entities.Farmacia;
import com.lab.entities.Medicamento;

@Repository
@Transactional
public interface FarmaciaRepository extends CrudRepository<Farmacia, Integer> {
	
	
	
	List<Farmacia> findByNombre (String nombre);
	
	@Query("Select f from Farmacia f where f.distrito.id_distrito = :distritoId")
	List<Farmacia> findByCodeDistrito(@Param("distritoId") int distritoId);
	
	

}
