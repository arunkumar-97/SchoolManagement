package com.jesperapps.schoolmanagement.api.utils;


public class StorageUtils {
	public static String BASE_URL="//home//jespersoft//public_html//schoolqa-api//uploads//";
	
	public static String getFolderLocation(String folderName) {
		return StorageUtils.BASE_URL+folderName+"//";
	}
}
