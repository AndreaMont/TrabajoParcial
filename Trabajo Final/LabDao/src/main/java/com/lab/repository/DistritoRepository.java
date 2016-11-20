package com.lab.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lab.entities.Distrito;

@Repository
@Transactional
public interface DistritoRepository extends CrudRepository<Distrito, Integer>{
	
	List<Distrito> findByNombre(String nombre);

}
