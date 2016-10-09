package com.seguro.factory;

import com.seguro.dao.IUsuariodao;
import com.seguro.dao.impl.Usuariodao;

public class Factory {

private static Factory fac;
	
	private Factory(){
		
	}
	
	
	public static Factory getInstance(){
		if(fac==null)
			fac=new Factory();
		return fac;
	}
	
	
	public IUsuariodao getUsuariodao(){
		return new Usuariodao();
				
	}
}
