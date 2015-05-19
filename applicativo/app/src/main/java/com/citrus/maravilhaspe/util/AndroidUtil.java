package com.citrus.maravilhaspe.util;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AndroidUtil {
	
	public static final String JPEG_EXTENSION = ".jpg";
	
	public static final Map<String, Map<String, String>> COUNTRYS_STATES_MAP = createStatesMAP();
	public static final List<String> COUNTRYS_NAME = createCountrysName();
	public static final List<String> COUNTRYS_ID = createCountrysId();
	private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
	
	private static Map<String, Map<String, String>> createStatesMAP(){
		Map<String, String> statesTmp = new HashMap<String, String>();
		Map<String, Map<String, String>> countryStatesTmp = new HashMap<String, Map<String,String>>();
		
		
	    statesTmp.put("Acre", "AC");
	    statesTmp.put("Alagoas", "AL");
	    statesTmp.put("Amapá", "AP");
	    statesTmp.put("Amazonas", "AM");
	    statesTmp.put("Bahia", "BA");
	    statesTmp.put("Ceará", "CE");
	    statesTmp.put("Distrito Federal", "DF");
	    statesTmp.put("Espírito Santo", "ES");
	    statesTmp.put("Goiás", "GO");
	    statesTmp.put("Maranhão", "MA");
	    statesTmp.put("Mato Grosso", "MT");
	    statesTmp.put("Mato Grosso do Sul", "MS");
	    statesTmp.put("Minas Gerais", "MG");
	    statesTmp.put("Pará", "PA");
	    statesTmp.put("Paraíba", "PB");
	    statesTmp.put("Paraná", "PR");
	    statesTmp.put("Pernambuco", "PE");
	    statesTmp.put("Piauí", "PI");
	    statesTmp.put("Rio de Janeiro", "RJ");
	    statesTmp.put("Rio Grande do Norte", "RN");
	    statesTmp.put("Rio Grande do Sul", "RS");
	    statesTmp.put("Rondonia", "RO");
	    statesTmp.put("Roraima","RR");
	    statesTmp.put("Santa Catarina", "SC");
	    statesTmp.put("São Paulo", "SP");
	    statesTmp.put("Sergipe", "SE");
	    statesTmp.put("Tocantins", "TO");
	    
	    countryStatesTmp.put("BR", statesTmp);
	    
	    return Collections.unmodifiableMap(countryStatesTmp);
	}
	
	private static ArrayList<String> createCountrysName(){
		ArrayList<String> countrysTmp = new ArrayList<String>();
		countrysTmp.add("Brasil");
		
		return countrysTmp;
	}
	
	private static ArrayList<String> createCountrysId(){
		ArrayList<String> countrysTmp = new ArrayList<String>();
		countrysTmp.add("BR");
		
		return countrysTmp;
	}
	
	public static Map<String, String> reverseStatesMap(String country_id){
		HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, String> statesMap = (HashMap<String, String>) COUNTRYS_STATES_MAP.get(country_id);
		for(String key: statesMap.keySet()){
			map.put(statesMap.get(key), key);
		}
		return map;
		
	}
	
	public static boolean hasInternetConnection(Context context){
		final ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    	final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
    	if ( activeNetwork != null && activeNetwork.isConnected() ){
    		return true;
    	}
    	
    	return false;
	}
	
	public static int generateViewId() {
	    for (;;) {
	        final int result = sNextGeneratedId.get();
	        // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
	        int newValue = result + 1;
	        if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
	        if (sNextGeneratedId.compareAndSet(result, newValue)) {
	            return result;
	        }
	    }
	}
	
	public static float dipToPixels(Resources res, float dipValue) {
	    DisplayMetrics metrics = res.getDisplayMetrics();
	    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
	}
	
	@SuppressLint("SimpleDateFormat")
	public static File createImageFile() throws IOException{
		// Create an image file name
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String imageFileName = "JPEG_" + timeStamp + "_";
	    File storageDir = Environment.getExternalStoragePublicDirectory(
	            Environment.DIRECTORY_PICTURES);
	    File image = File.createTempFile(
	        imageFileName,  /* prefix */
	        JPEG_EXTENSION,         /* suffix */
	        storageDir      /* directory */
	    );
	    return image;
    }
	
	public static Bitmap getRoundedImage(Bitmap bitmap){
		Bitmap circleBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

		BitmapShader shader = new BitmapShader (bitmap,  TileMode.CLAMP, TileMode.CLAMP);
		Paint paint = new Paint();
		paint.setShader(shader);

		Canvas c = new Canvas(circleBitmap);
		c.drawCircle(bitmap.getWidth()/2, bitmap.getHeight()/2, bitmap.getWidth()/2, paint);

		return circleBitmap;
	}
	
	public static Bitmap getRoundedImage(Resources res, int resId, float reqWidthInDip, float reqHeightInDip){
    	
		//Bitmap bitmap = decodeSampledBitmapFromResource(res,
        //        R.drawable.default_profile, reqWidthInDip, reqHeightInDip);
		//
		//return getRoundedImage(bitmap);
        return null;
	}
	
	private static final String capitalize(String str) {
	    if (TextUtils.isEmpty(str)) {
	        return str;
	    }
	    final char[] arr = str.toCharArray();
	    boolean capitalizeNext = true;
	    String phrase = "";
	    for (final char c : arr) {
	        if (capitalizeNext && Character.isLetter(c)) {
	            phrase += Character.toUpperCase(c);
	            capitalizeNext = false;
	            continue;
	        } else if (Character.isWhitespace(c)) {
	            capitalizeNext = true;
	        }
	        phrase += c;
	    }
	    return phrase;
	}

	/** Returns the consumer friendly device name */
	public static String getDeviceName() {
	    final String manufacturer = Build.MANUFACTURER;
	    final String model = Build.MODEL;
	    if (model.startsWith(manufacturer)) {
	        return capitalize(model);
	    }
	    if (manufacturer.equalsIgnoreCase("HTC")) {
	        // make sure "HTC" is fully capitalized.
	        return "HTC " + model;
	    }
	    return capitalize(manufacturer) + " " + model;
	}
	
	//Check String is Base64
	
	/** */
    private static final int  BASELENGTH = 255;

    /** */
    private static final int  LOOKUPLENGTH = 64;

    /** The padding character */
    private static final byte PAD = (byte) '=';

    /** The alphabet */
    private static final byte [] BASE64_ALPHABET = new byte[BASELENGTH];

    /** The lookup alphabet */
    private static final byte [] LOOKUP_BASE64_ALPHABET = new byte[LOOKUPLENGTH];

    static {

        for (int i = 0; i < BASELENGTH; i++) {
            BASE64_ALPHABET[i] = -1;
        }
        for (int i = 'Z'; i >= 'A'; i--) {
            BASE64_ALPHABET[i] = (byte) (i - 'A');
        }
        for (int i = 'z'; i >= 'a'; i--) {
            BASE64_ALPHABET[i] = (byte) (i - 'a' + 26);
        }

        for (int i = '9'; i >= '0'; i--) {
            BASE64_ALPHABET[i] = (byte) (i - '0' + 52);
        }

        BASE64_ALPHABET['+']  = 62;
        BASE64_ALPHABET['/']  = 63;

        for (int i = 0; i <= 25; i++) {
            LOOKUP_BASE64_ALPHABET[i] = (byte) ('A' + i);
        }

        for (int i = 26, j = 0; i <= 51; i++, j++) {
            LOOKUP_BASE64_ALPHABET[i] = (byte) ('a' + j);
        }

        for (int i = 52,  j = 0; i <= 61; i++, j++) {
            LOOKUP_BASE64_ALPHABET[i] = (byte) ('0' + j);
        }
        LOOKUP_BASE64_ALPHABET[62] = (byte) '+';
        LOOKUP_BASE64_ALPHABET[63] = (byte) '/';

    }

    /**
     * Return true if the specified string is base64 encoded.
     * @param isValidString The string to test.
     * @return boolean True if the string is base64.
     */
    public static boolean isBase64(String isValidString) {
        return isArrayByteBase64(isValidString.getBytes());
    }


    /**
     * Return true if the specified octect is base64
     * @param octect The octet to test.
     * @return boolean True if the octect is base64.
     */
    static boolean isBase64(byte octect) {
        // Should we ignore white space?
        return (octect == PAD || BASE64_ALPHABET[octect] != -1);
    }

    /**
     * Return true if the specified byte array is base64
     * @param arrayOctect The array to test.
     * @return boolean true if the specified byte array is base64
     */
    public static boolean isArrayByteBase64(byte[] arrayOctect) {
        int length = arrayOctect.length;
        if (length == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!isBase64(arrayOctect[i])) {
                return false;
            }
        }
        return true;
    }
    
    //Check GPS
    
    public static void isGPSActivated(final Context context){
    	LocationManager lm = null;
    	 boolean gpsEnabled = false;
    	    if(lm==null)
    	        lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
			try{
				gpsEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
			}catch(Exception ex){}

			if(!gpsEnabled){
    	        AlertDialog.Builder dialog = new AlertDialog.Builder(context);

    	        dialog.setCancelable(false);
    	        dialog.show();

    	    }
    }
    
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
	    // Raw height and width of image
	    final int height = options.outHeight;
	    final int width = options.outWidth;
	    int inSampleSize = 1;
	
	    if (height > reqHeight || width > reqWidth) {
	
	        final int halfHeight = height / 2;
	        final int halfWidth = width / 2;
	
	        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
	        // height and width larger than the requested height and width.
	        while ((halfHeight / inSampleSize) > reqHeight
	                && (halfWidth / inSampleSize) > reqWidth) {
	            inSampleSize *= 2;
	        }
	    }
	
	    return inSampleSize;
	}
    
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
            int reqWidthInPixel, int reqHeightInPixel) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidthInPixel, reqHeightInPixel);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
    
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
            float reqWidthInDip, float reqHeightInDip) {
    	
    	int reqWidthInPixel = (int) dipToPixels(res, reqWidthInDip);
    	int reqHeightInPixel = (int) dipToPixels(res, reqHeightInDip);

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidthInPixel, reqHeightInPixel);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
    
    public static Bitmap decodeSampledBitmapFromFile(Resources res, ContentResolver contentResolver,File file,
            float reqWidthInDip, float reqHeightInDip) throws IOException {
    	
    	Bitmap bitmap;
    	AssetFileDescriptor fileDescriptor;
    	int reqWidthInPixel = (int) dipToPixels(res, reqWidthInDip);
    	int reqHeightInPixel = (int) dipToPixels(res, reqHeightInDip);
		fileDescriptor = contentResolver.openAssetFileDescriptor(Uri.fromFile(file),"r"); 

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor.getFileDescriptor(), null, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidthInPixel, reqHeightInPixel);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor.getFileDescriptor(), null, options); 
		fileDescriptor.close();
        return bitmap;
    }
    
    public static Bitmap decodeSampledBitmapFromFile(Resources res, ContentResolver contentResolver,File file,
            int reqWidthInPixel, int reqHeightInPixel) throws IOException {
    	
    	Bitmap bitmap;
    	AssetFileDescriptor fileDescriptor;
    	
		fileDescriptor = contentResolver.openAssetFileDescriptor(Uri.fromFile(file),"r"); 

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor.getFileDescriptor(), null, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidthInPixel, reqHeightInPixel);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor.getFileDescriptor(), null, options); 
		fileDescriptor.close();
        return bitmap;
    }
    
    public static Bitmap decodeSampledBitmapFromFile(Resources res, ContentResolver contentResolver,Uri uri,
            float reqWidthInDip, float reqHeightInDip) throws IOException {
    	
    	Bitmap bitmap;
    	AssetFileDescriptor fileDescriptor;
    	int reqWidthInPixel = (int) dipToPixels(res, reqWidthInDip);
    	int reqHeightInPixel = (int) dipToPixels(res, reqHeightInDip);
		fileDescriptor = contentResolver.openAssetFileDescriptor(uri,"r"); 

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor.getFileDescriptor(), null, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidthInPixel, reqHeightInPixel);
        
        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor.getFileDescriptor(), null, options); 
		fileDescriptor.close();
        return bitmap;
    }
    
    public static Bitmap decodeSampledBitmapFromFile(Resources res, ContentResolver contentResolver,Uri uri,
            int reqWidthInPixel, int reqHeightInPixel) throws IOException {
    	
    	Bitmap bitmap;
    	AssetFileDescriptor fileDescriptor;
    	
		fileDescriptor = contentResolver.openAssetFileDescriptor(uri,"r"); 

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor.getFileDescriptor(), null, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidthInPixel, reqHeightInPixel);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor.getFileDescriptor(), null, options); 
		fileDescriptor.close();
        return bitmap;
    }
    
    public static Bitmap resizeProfilePicture(Resources res, Bitmap bitmap){
		if(bitmap == null) return null;
		int size = (int) AndroidUtil.dipToPixels(res, 200);
		if(bitmap.getWidth() > bitmap.getHeight()){
    		if(bitmap.getWidth() > size){
    			bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.round(bitmap.getWidth()*(((float)size)/bitmap.getHeight())), size, false);
    			bitmap = Bitmap.createBitmap(bitmap, ((bitmap.getWidth()-bitmap.getHeight())/2), 0, bitmap.getHeight(), bitmap.getHeight());
    		}else{
    			bitmap = Bitmap.createBitmap(bitmap, ((bitmap.getWidth()-bitmap.getHeight())/2), 0, bitmap.getHeight(), bitmap.getHeight());
    			bitmap = Bitmap.createScaledBitmap(bitmap, size, size, false);
    		}
    	}else if(bitmap.getWidth() < bitmap.getHeight()){
    		if(bitmap.getHeight() > size){
    			bitmap = Bitmap.createScaledBitmap(bitmap, size, (int) Math.round(bitmap.getHeight()*(((float)size)/bitmap.getWidth())), false);
    			bitmap = Bitmap.createBitmap(bitmap, 0, ((bitmap.getHeight()-bitmap.getWidth())/2), bitmap.getWidth(), bitmap.getWidth());
    		}else{
    			bitmap = Bitmap.createBitmap(bitmap, 0, ((bitmap.getHeight()-bitmap.getWidth())/2), bitmap.getWidth(), bitmap.getWidth());
    			bitmap = Bitmap.createScaledBitmap(bitmap, size, size, false);
    		}
    	}else{
    		bitmap = Bitmap.createScaledBitmap(bitmap, size, size, false);
    	}
		
		return bitmap;
	}
    
    @SuppressLint("SimpleDateFormat")
	public static String getFormattedCurrentDate(){
    	Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = df.format(c.getTime());
		
		return formattedDate;
    }

}
