package com.citrus.maravilhaspe.generic;


import com.citrus.maravilhaspe.generic.persistence.IRESTAccess;
import com.citrus.maravilhaspe.generic.persistence.RESTAccess;

public class GenericFactory {
	
	private static final GenericFactory INSTANCE = new GenericFactory();
	private static IRESTAccess REST_ACCESS;

	public GenericFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public synchronized static GenericFactory getInstance() {
		return INSTANCE;
	}
	
	public synchronized IRESTAccess createRestAccess(){
		if(REST_ACCESS == null){
			REST_ACCESS = new RESTAccess();
		}
		return REST_ACCESS;
		
	}

}
