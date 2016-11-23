package com.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lab.entities.Orden;

@Repository
@Transactional
public interface OrdenRepository extends CrudRepository<Orden, Integer> 
{
	
	
	@Query("select o from Orden o order by o.montototal desc")
	Iterable<Orden> findByMontototalDESC();
	
	
	@Query("select o from Orden o where o.f_orden between ?1 and ?2")
	List<Orden> findByF_orden(String fo1,String fo2);
	

	@Query("Select count(o) from Orden o")
	int countOrdenFarmacia();

	@Query("Select o from Orden o where o.farmacia.id_farmacia = :farmaciaId")
	List<Orden> findByCodeFarmacia(@Param("farmaciaId") int farmaciaId);
		
}
