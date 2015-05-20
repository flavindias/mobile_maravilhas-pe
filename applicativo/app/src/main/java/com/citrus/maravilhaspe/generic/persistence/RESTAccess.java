package com.citrus.maravilhaspe.generic.persistence;


import android.util.Log;

import com.citrus.maravilhaspe.util.HTTPMultiPartEntity;
import com.citrus.maravilhaspe.util.HTTPUtil;

import java.io.File;
import java.util.HashMap;

public class RESTAccess implements IRESTAccess {
	
	private static final String HOST = "http://172.16.130.194/maravilhaspe/mobile_maravilhas-pe/sistema/"; //"http://api.qe2.swquality.com.br/";
	private static final String WEBSITE_HOST = "http://172.16.130.194/maravilhaspe/mobile_maravilhas-pe/sistema/"; //"http://qe2.swquality.com.br/";
	
	public RESTAccess() {
	}
	
	public String executeGetImage(String suffix){
		String content = HTTPUtil.accessImage(WEBSITE_HOST + suffix);
		
		return content;
	}
	
	public String executeGetMethod(String suffix){
		Log.i("log-maravilha", HOST + suffix);
		String content = HTTPUtil.access((HOST + suffix), HTTPUtil.METHOD_GET);
		
		return content;
		
	}
	
	public String executeGetMethod(String suffix, String username, String password){
		
		String content = HTTPUtil.access((HOST + suffix), HTTPUtil.METHOD_GET, username, password);
		
		return content;
		
	}
	
	public String executePostMethod(String suffix, String params){
		
		String content = HTTPUtil.access((HOST + suffix), HTTPUtil.METHOD_POST, params);
		
		return content;
	}
	
	public String executePostMethod(String suffix, HashMap<String, String> params, HashMap<String, File> files){
		
		String content = HTTPUtil.access((HOST + suffix), HTTPUtil.METHOD_POST, params, files);
		
		return content;
	}
	
	public String executePostMethod(String suffix, HTTPMultiPartEntity entity){
		
		String content = HTTPUtil.accessPostMultiPart((HOST + suffix), entity);
		
		return content;
	}
	
	public String executePostMethod(String suffix, String params, String username, String password){
		
		String content = HTTPUtil.access((HOST + suffix), HTTPUtil.METHOD_POST, params, username, password);
		
		return content;
	}
	
	public String executePostMethod(String suffix, HashMap<String, String> params, HashMap<String, File> files, String username, String password){
		
		String content = HTTPUtil.access((HOST + suffix), HTTPUtil.METHOD_POST, params, files, username, password);
		
		return content;
	}
	
	public String executePostMethod(String suffix, HTTPMultiPartEntity entity, String username, String password){
		
		String content = HTTPUtil.accessPostMultiPart((HOST + suffix), entity, username, password);
		
		return content;
	}
	
	public String executeDeleteMethod(String suffix, String params){
		return null;
		
	}
	
	public String executeDeleteMethod(String suffix, String params, String username, String password){
		return null;
		
	}

}
