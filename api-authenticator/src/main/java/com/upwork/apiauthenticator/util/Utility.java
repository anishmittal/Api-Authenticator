package com.upwork.apiauthenticator.util;

public class Utility {
	
	private static String APIKEY = "$12345";
	
	static public boolean validateAPIKey(String apiKey) {
		return APIKEY.equalsIgnoreCase(apiKey);
	}

}
