package com.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lab.entities.Orden;

@Repository
@Transactional
public interface OrdenRepository extends CrudRepository<Orden, Integer> 
{
	
	List<Orden> findByFarmaciaOrderByMontototalDesc (int id_farmacia);

	@Query("select o from Orden o where o.precioventa between ?1 and ?2")
	List<Orden> findByPrecioVenta(double pv1,double pv2);
	

	@Query("Select count(f) from Orden f where f.id_farmacia=?1")
	int countOrdenByFarmacia(int id_farmacia);
	

}
