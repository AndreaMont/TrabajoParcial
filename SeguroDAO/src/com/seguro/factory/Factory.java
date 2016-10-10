package com.seguro.factory;

import com.seguro.dao.ICitadao;
import com.seguro.dao.IClientedao;
import com.seguro.dao.ICotizaciondao;
import com.seguro.dao.IInspectordao;
import com.seguro.dao.IPolizadao;
import com.seguro.dao.IVehiculodao;
import com.seguro.dao.impl.Citadao;
import com.seguro.dao.impl.Clientedao;
import com.seguro.dao.impl.Cotizaciondao;
import com.seguro.dao.impl.Inspectordao;
import com.seguro.dao.impl.Polizadao;
import com.seguro.dao.impl.Vehiculodao;

public class Factory {

private static Factory fac;
	
	private Factory(){
		
	}
	
	
	public static Factory getInstance(){
		if(fac==null)
			fac=new Factory();
		return fac;
	}
	
	
	public IClientedao getClientedao(){
		return new Clientedao();
				
	}
	
	public IInspectordao getInspectordao(){
		return new Inspectordao();
	}
	public IVehiculodao getVehiculodao(){
		return new Vehiculodao();
	}
	public ICitadao getCitadao(){
		return new Citadao();
		
	}
	public ICotizaciondao getCotizaciondao(){
		return new Cotizaciondao();
	}
	public IPolizadao getPolizadao(){
		return new Polizadao();
	}
	
}
