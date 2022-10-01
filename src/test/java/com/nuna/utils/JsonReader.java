package com.nuna.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonReader {
	
	private static Object obj;

	public static void readProperties(String filePath) throws FileNotFoundException  {
		
		JSONParser  jsonparser = new JSONParser();
		
		FileReader reader = new FileReader(filePath);
				
		try {
			obj = jsonparser.parse(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getJsonProperty(String key) {
		
		JSONObject configsObj = (JSONObject) obj;
		
		return configsObj.get(key).toString();

}
	
}