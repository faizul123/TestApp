package com.test.util;

public class URLDirectory {
	
	// Default resource
	public static final String upload = "/file/upload";
	
	public static final String download = "/file/download";
	
	public static final String listAllFiles = "/files";
	
	public static final String removefile = "/file/{key}";
	
	// App resource	
	private static final String appRoot = "/app";
	
	public static final String newApp = "/app";
		
	public static final String publish = appRoot + "/publish";
	
	public static final String removeApp = "app/{id}";
	
	public static final String listAllAppsInfo = "/apps";
	
	private URLDirectory(){}
}
