package com.seguro.factory;

import com.seguro.dao.IClientedao;
import com.seguro.dao.IInspectordao;
import com.seguro.dao.impl.Clientedao;
import com.seguro.dao.impl.Inspectordao;

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
}
