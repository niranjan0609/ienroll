package com.ienroll.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static int getCharCount(String str) {
		int count = 0;
	    for(int i =0; i < str.length(); i++){
	        if(str.charAt(i) == 'i'){
	            count++;
	            }
	    }
	    return count;
	}
	
	public static String getDateTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("MMddYYYY");
		Date date = new Date();
		System.out.println(sdf.format(date));
		return sdf.format(date);
	}
	
	public static String getCurrentTimeStamp() {
		return new SimpleDateFormat("ddMMyyyy-HHmm").format(new Date());
	}
	
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}

}
