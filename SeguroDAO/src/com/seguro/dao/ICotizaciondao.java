package com.seguro.dao;

import java.sql.SQLException;
import java.util.List;

import com.seguro.dto.CotizacionInicial;

public interface ICotizaciondao extends ICruddao<CotizacionInicial>, IRowmapper<CotizacionInicial> {
	
	List<CotizacionInicial> listarCotizacionInicial (float cotizacionInicial)throws SQLException;
	

}
