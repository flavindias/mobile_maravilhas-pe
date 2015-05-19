package com.citrus.maravilhaspe.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;


public class HTTPUtil {
	
	public final static int READ_TIMEOUT = 30000;
	public final static int CONNECT_TIMEOUT = 10000;
	public final static String METHOD_POST = "POST";
	public final static String METHOD_DELETE = "DELETE";
	public final static String METHOD_GET = "GET";
	
	public static String externalAccess(String link,String method){
		URL url = null;
		HttpURLConnection conn = null;
		try{
			url =  new URL(link);
			conn = (HttpURLConnection) url.openConnection();
			conn = setOptionsConnection(conn, method, "", "");
			String content = readStream(conn);
			
			return content;
		} catch (IOException e){
			conn.disconnect();
			try {
				return getHttpError(conn.getResponseCode());
			} catch (IOException e1) {
				return "ERROR_UNEXPECTED";
			}
		}
		
	}
	
	public static String accessImage(String link){
		URL url = null;
		HttpURLConnection conn = null;
		Bitmap image = null;
		try{
			url =  new URL(link);
			conn = (HttpURLConnection) url.openConnection();
			image = BitmapFactory.decodeStream(conn.getInputStream());
			
			if(image != null){
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
				image.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
				byte[] byteArray = byteArrayOutputStream.toByteArray();
				
				String content = android.util.Base64.encodeToString(byteArray, android.util.Base64.NO_WRAP);
				
				return content;
			}
			
			return "ERROR_UNEXPECTED";
		} catch (IOException e){
			conn.disconnect();
			try {
				return getHttpError(conn.getResponseCode());
			} catch (IOException e1) {
				return "ERROR_UNEXPECTED";
			}
		}
		
	}
	
	public static String access(String link,String method){
		URL url = null;
		HttpURLConnection conn = null;
		try{
			url =  new URL(link);
			conn = (HttpURLConnection) url.openConnection();
			conn = setOptionsConnection(conn, method, "", "");
			String content = readStream(conn);
			
			return content;
		} catch (IOException e){
			conn.disconnect();
			try {
				return getHttpError(conn.getResponseCode());
			} catch (IOException e1) {
				return "ERROR_UNEXPECTED";
			}
		}
		
	}
	
	public static String access(String link, String method, String username, String password){
		URL url = null;
		HttpURLConnection conn = null;
		try{
			url =  new URL(link);
			conn = (HttpURLConnection) url.openConnection();
			conn = setOptionsConnection(conn, method, username, password);
			String content = readStream(conn);
			
			return content;
		} catch (IOException e){
			conn.disconnect();
			try {
				return getHttpError(conn.getResponseCode());
			} catch (IOException e1) {
				return "ERROR_UNEXPECTED";
			}
		}
		
	}
	
	public static String accessPostMultiPart(String link, HTTPMultiPartEntity entity, String username, String password){
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(link);
		
		String authString = username + ":" + password;
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authStringEnc = new String(authEncBytes);
		httpPost.setHeader("Authorization", "Basic " + authStringEnc);
		
		httpPost.setEntity(entity);
		
		HttpResponse response;
		try {
			response = httpClient.execute(httpPost);
		    HttpEntity rEntity = response.getEntity();
		
		    Integer status = response.getStatusLine().getStatusCode();
		    if(status.equals(HttpStatus.SC_OK)) return EntityUtils.toString(rEntity);
		    else if(status.equals(HttpStatus.SC_UNAUTHORIZED)) return "UNAUTHORIZED";
		    else if(status.equals(HttpStatus.SC_METHOD_NOT_ALLOWED)) return "NOT_ALLOWED";
		    else if(status.equals(HttpStatus.SC_GATEWAY_TIMEOUT)) return "TIMEOUT";
		    else if(status.equals(HttpStatus.SC_NOT_FOUND)) return "NOT_FOUND";
		    else if(status.equals(HttpStatus.SC_REQUEST_TIMEOUT)) return "TIMEOUT";
			
		    return "ERROR_UNEXPECTED";
		
		} catch (ClientProtocolException e) {
			return "ERROR_UNEXPECTED";
		} catch (IOException e) {
			return "ERROR_UNEXPECTED";
		}
		
	}
	
	public static String accessPostMultiPart(String link, HTTPMultiPartEntity entity){
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(link);
		
		httpPost.setEntity(entity);
		
		HttpResponse response;
		try {
			response = httpClient.execute(httpPost);
		    HttpEntity rEntity = response.getEntity();
		
		    Integer status = response.getStatusLine().getStatusCode();
		    if(status.equals(HttpStatus.SC_OK)) return EntityUtils.toString(rEntity);
		    else if(status.equals(HttpStatus.SC_UNAUTHORIZED)) return "UNAUTHORIZED";
		    else if(status.equals(HttpStatus.SC_METHOD_NOT_ALLOWED)) return "NOT_ALLOWED";
		    else if(status.equals(HttpStatus.SC_GATEWAY_TIMEOUT)) return "TIMEOUT";
		    else if(status.equals(HttpStatus.SC_NOT_FOUND)) return "NOT_FOUND";
		    else if(status.equals(HttpStatus.SC_REQUEST_TIMEOUT)) return "TIMEOUT";
			
		    return "ERROR_UNEXPECTED";
		
		} catch (ClientProtocolException e) {
			return "ERROR_UNEXPECTED";
		} catch (IOException e) {
			return "ERROR_UNEXPECTED";
		}
		
	}
	
	public static String access(String link, String method, String data){
		URL url = null;
		HttpURLConnection conn = null;
		try{
			url =  new URL(link);
			conn = (HttpURLConnection) url.openConnection();
			conn = setOptionsConnection(conn, method, "", "");
			writeStream(conn, data);
			String content = readStream(conn);
			
			return content;
		} catch (IOException e){
			conn.disconnect();
			try {
				return getHttpError(conn.getResponseCode());
			} catch (IOException e1) {
				return "ERROR_UNEXPECTED";
			}
		}
		
	}
	
	public static String access(String link, String method, HashMap<String, String> data, HashMap<String, File> files){
		URL url = null;
		HttpURLConnection conn = null;
		try{
			url =  new URL(link);
			conn = (HttpURLConnection) url.openConnection();
			conn = setOptionsConnection(conn, method, "", "");
			writeStream(conn, data, files);
			String content = readStream(conn);
			
			return content;
		} catch (IOException e){
			Log.d("DebbugFindUp", e.toString());
			conn.disconnect();
			try {
				return getHttpError(conn.getResponseCode());
			} catch (IOException e1) {
				Log.d("DebbugFindUp", e1.toString());
				return "ERROR_UNEXPECTED";
			}
		}
		
	}
	
	public static String access(String link, String method, String data, String username, String password){
		URL url = null;
		HttpURLConnection conn = null;
		try{
			url =  new URL(link);
			conn = (HttpURLConnection) url.openConnection();
			conn = setOptionsConnection(conn, method, username, password);
			writeStream(conn, data);
			String content = readStream(conn);
			
			return content;
		} catch (IOException e){
			conn.disconnect();
			try {
				return getHttpError(conn.getResponseCode());
			} catch (IOException e1) {
				return "ERROR_UNEXPECTED";
			}
		}
		
	}
	
	public static String access(String link, String method, HashMap<String, String> data, HashMap<String, File> files, String username, String password){
		URL url = null;
		HttpURLConnection conn = null;
		try{
			url =  new URL(link);
			conn = (HttpURLConnection) url.openConnection();
			conn = setOptionsConnection(conn, method, username, password);
			writeStream(conn, data, files);
			String content = readStream(conn);
			
			return content;
		} catch (IOException e){
			Log.d("DebbugFindUp", e.toString() +" 1");
			conn.disconnect();
			try {
				return getHttpError(conn.getResponseCode());
			} catch (IOException e1) {
				Log.d("DebbugFindUp", e1.toString()+" 2");
				return "ERROR_UNEXPECTED";
			}
		}
		
	}
	
	private static HttpURLConnection setOptionsConnection(HttpURLConnection conn, String method, String username, String password) throws IOException{
		conn = setOptionsConnection(conn, username, password);
		conn.setRequestMethod(method);
		if(method == "POST" || method == "DELETE")
			conn.setDoOutput(true);
		
		return conn;
	}
	
	private static HttpURLConnection setOptionsConnection(HttpURLConnection conn, String username, String password) throws IOException{
		conn.setConnectTimeout(CONNECT_TIMEOUT);
		conn.setReadTimeout(READ_TIMEOUT);
        conn.setDoInput(true);
        
        if(!username.isEmpty() && !password.isEmpty()){
		    String authString = username + ":" + password;
			byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
        }
		
		return conn;
	}
	
	private static String readStream(HttpURLConnection conn) throws IOException{
		String line, content = "";
	    BufferedReader reader = new BufferedReader(new 
	                                     InputStreamReader(conn.getInputStream()));
	    while ((line = reader.readLine()) != null) {
	    	content += line;
	    }
	    reader.close();
		
		return content;
	}
	
	private static void writeStream(HttpURLConnection conn, String data) throws IOException{
		OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

	    writer.write(data);
	    writer.flush();
	}
	
	private static void writeStream(HttpURLConnection conn, HashMap<String, String> data, HashMap<String, File> files) throws IOException{
		String boundary = Long.toHexString(System.currentTimeMillis()); // Just generate some unique random value.
		String CRLF = "\r\n"; // Line separator required by multipart/form-data.
		
		conn.setRequestProperty("Cache-Control", "no-cache");
		conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
		
		OutputStream output = conn.getOutputStream();
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(output), true);
		
		for(String key : data.keySet()){
		// Send normal param.
		    writer.append("--" + boundary).append(CRLF);
		    writer.append("Content-Disposition: form-data; name=\""+key+"\"").append(CRLF);
		    writer.append(CRLF).append(data.get(key)).append(CRLF).flush();
		}
		
		for(String key : files.keySet()){
		    // Send text file.
		    writer.append("--" + boundary).append(CRLF);
		    writer.append("Content-Disposition: form-data; name=\""+key+"\"; filename=\"" + files.get(key).getName() + "\"").append(CRLF);
		    writer.append("Content-Type: " +HttpURLConnection.guessContentTypeFromName(files.get(key).getName())).append(CRLF); // Text file itself must be saved in this charset!
		    writer.append("Content-Transfer-Encoding: binary").append(CRLF);
		    writer.append(CRLF).flush();
		    copyFiles(files.get(key), output);
		    output.flush(); // Important before continuing with writer!
		    writer.append(CRLF).flush(); // CRLF is important! It indicates end of boundary.
		}

	 // End of multipart/form-data.
	    writer.append("--" + boundary + "--").append(CRLF).flush();
	}
	
	private static void copyFiles(File file, OutputStream output){
		InputStream input = null;
	    try {
	        input = new FileInputStream(file);
	        byte[] buffer = new byte[1024];
	        for (int length = 0; (length = input.read(buffer)) > 0;) {
	            output.write(buffer, 0, length);
	        }
	        output.flush(); // Important! Output cannot be closed. Close of
	        // writer will close output as well.
	    } catch (FileNotFoundException e) {
	    	Log.e("DebbugFindUp", e.toString() +"HTTPUtil.copyFiles");
		} catch (IOException e) {
			Log.e("DebbugFindUp", e.toString() +"HTTPUtil.copyFiles");
		} finally {
	        if (input != null) try {
	            input.close();
	        } catch (IOException logOrIgnore) {}
	    }
	}
	
	private static String getHttpError(Integer status){
		if(status.equals(HttpStatus.SC_UNAUTHORIZED)) return "UNAUTHORIZED";
		else if(status.equals(HttpStatus.SC_FORBIDDEN)) return "FORBIDDEN";
		else if(status.equals(HttpStatus.SC_GATEWAY_TIMEOUT)) return "TIMEOUT";
		else if(status.equals(HttpStatus.SC_NOT_FOUND)) return "NOT_FOUND";
		else if(status.equals(HttpStatus.SC_REQUEST_TIMEOUT)) return "TIMEOUT";
		return "ERROR_UNEXPECTED";
	}
}
