package com.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lab.entities.Farmacia;

@Repository
@Transactional
public interface FarmaciaRepository extends CrudRepository<Farmacia, Integer> {
	
	
	@Query("SELECT d FROM Farmacia d WHERE d.distrito=id_distrito = :distrito")
	List<Farmacia> findByNamedistrito(@Param("distrito") String distrito);

	//@Query("Select f from Farmacia f where f.id_farmacia=?1")
	//List<Farmacia>
}
