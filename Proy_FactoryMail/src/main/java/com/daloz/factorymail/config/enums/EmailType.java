package com.daloz.factorymail.config.enums;

public enum EmailType
{
	GMAIL("gmail.properties"), OUTLOOK("outlook.properties");
	
	private String properties;
	
	private EmailType(String properties)
	{
		this.properties = properties;
	}
	
	public String getProperties()
	{
		return properties;
	}
}
