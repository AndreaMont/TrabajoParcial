package com.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lab.entities.Medicamento;
import com.lab.entities.Orden;

@Repository
@Transactional
public interface OrdenRepository extends CrudRepository<Orden, Integer> 
{
	
/*	List<Orden> findAllByFarmaciaOrderByMontototalDesc (int id_farmacia);*/

	
	
	@Query("select o from Orden o where o.f_envio between ?1 and ?2")
	List<Orden> findByFechaEnvio(String fe1,String fe2);
	
	@Query("select o from Orden o where o.f_orden between ?1 and ?2")
	List<Orden> findByFechaOrden(String fo1,String fo2);
	
/*
	@Query("Select count(o) from Orden o where o.farmacia=?1")
	int countOrdenFarmacia(int farmacia);
	*/
	@Query("Select o from Orden o where o.farmacia.id_farmacia = :farmaciaId")
	List<Orden> findByCodeFarmacia(@Param("farmaciaId") int farmaciaId);
		
}
