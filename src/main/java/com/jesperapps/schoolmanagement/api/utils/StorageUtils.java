package com.jesperapps.schoolmanagement.api.utils;


public class StorageUtils {
//	public static String BASE_URL="//home//jespersoft//public_html//schoolqa-api//uploads//";

//	public static String BASE_URL="https://www.jespersoft.com//schoolqa-api//uploads//";
	public static String BASE_URL = "E:\\ContentUploading\\";
	public static String getFolderLocation(String folderName) {
				String trailingSlashes = "//";
//		String trailingSlashes = "\\";
		return StorageUtils.BASE_URL+folderName+trailingSlashes;
	}
}
