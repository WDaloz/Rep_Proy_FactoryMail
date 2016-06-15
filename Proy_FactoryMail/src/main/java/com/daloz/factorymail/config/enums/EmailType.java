package com.daloz.factorymail.config.enums;

public enum EmailType
{
	GMAIL("gmail.properties"), OUTLOOK("outlook.properties");
	
	private String getPath;
	
	private EmailType(String path)
	{
		this.getPath = path;
	}
	
	public String getPath()
	{
		return getPath;
	}
}
