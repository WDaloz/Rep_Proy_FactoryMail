package com.daloz.factorymail.config.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesHelper
{
	public static Properties getProperties(String name)
	{
		Properties properties = new Properties();
		
		try
		{
			properties.load(new InputStreamReader(new FileInputStream(getPackage().concat(name))));
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return properties;
	}
	
	private static String getPackage()
	{
		return "src/main/java/"+PropertiesHelper.class.getPackage().getName().toString().replace(".", "/").concat("/");
	}
}
