package com.lab.repository;

import java.util.Date;
import java.util.List;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lab.entities.Orden;

@Repository
@Transactional
public interface OrdenRepository extends CrudRepository<Orden, Integer> 
{
	
	
	@Query("select o from Orden o where o.farmacia.id_farmacia = :farmaciaId order by o.montototal desc")
	Iterable<Orden> findByMontototalDESC(@Param("farmaciaId") int farmaciaId);
	
	
	@Query("select o from Orden o where o.f_orden between :date1 and :date2")
	List<Orden> findByF_ordenBetween(@Param("date1") String date1 ,@Param("date2") String date2);
	

	@Query("Select count(o) from Orden o where o.farmacia.id_farmacia = :farmaciaId")
	int countOrdenFarmacia(@Param("farmaciaId") int farmaciaId);

	@Query("Select o from Orden o where o.farmacia.id_farmacia = :farmaciaId")
	List<Orden> findByCodeFarmacia(@Param("farmaciaId") int farmaciaId);
		
}
