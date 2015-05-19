package com.citrus.maravilhaspe.generic.persistence;


import com.citrus.maravilhaspe.util.HTTPMultiPartEntity;

import java.io.File;
import java.util.HashMap;

public interface IRESTAccess {
	String executePostMethod(String suffix, String params);
	String executePostMethod(String suffix, String params, String username, String password);
	String executePostMethod(String suffix, HashMap<String, String> params, HashMap<String, File> files);
	String executePostMethod(String suffix, HashMap<String, String> params, HashMap<String, File> files, String username, String password);
	String executePostMethod(String suffix, HTTPMultiPartEntity entity);
	String executePostMethod(String suffix, HTTPMultiPartEntity entity, String username, String password);
	String executeGetMethod(String suffix);
	String executeGetMethod(String suffix, String username, String password);
	String executeDeleteMethod(String suffix, String params);
	String executeDeleteMethod(String suffix, String params, String username, String password);
	String executeGetImage(String suffix);
}
