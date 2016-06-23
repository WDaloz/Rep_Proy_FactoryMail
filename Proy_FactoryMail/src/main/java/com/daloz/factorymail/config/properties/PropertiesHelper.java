package com.daloz.factorymail.config.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper
{
	public static Properties getProperties(String name)
	{
		Properties properties = new Properties();
		
		try
		{
			
			properties.load(PropertiesHelper.class.getClassLoader().getResourceAsStream
					("com/daloz/factorymail/config/properties/"+name));
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
}
