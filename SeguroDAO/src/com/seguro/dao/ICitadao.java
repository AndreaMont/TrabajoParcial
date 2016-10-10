package com.seguro.dao;

import java.sql.SQLException;
import java.util.List;

import com.seguro.dto.Cita;
import com.seguro.dto.Cliente;

public interface ICitadao extends ICruddao<Cita>, IRowmapper<Cita> {
	
	List<Cita> listarCitasCliente(Cliente o) throws SQLException;
	
}
