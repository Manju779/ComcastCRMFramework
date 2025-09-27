package com.comcast.crm.generic.fileutility;


import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {

	public String getDataFromeJsonFile(String Key) throws Throwable
	{
		FileReader fileR=new FileReader("./configAppData/AppCommanData.json");
		JSONParser jp=new JSONParser();
		Object obj = jp.parse(fileR);
		JSONObject map=(JSONObject)obj;
		String data = (String)map.get(Key);
		return data;
		
	}
}
