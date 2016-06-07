package com.daloz.factorymail.core.impl;

import com.daloz.factorymail.core.IMailManager;
import com.daloz.factorymail.objects.FileProcessResponse;
import com.daloz.factorymail.objects.Mail;

public class GMailManager implements IMailManager
{
	private static GMailManager instance;
	
	private GMailManager()
	{
		
	}
	
	public static GMailManager getInstance()
	{
		if(instance == null)
		{
			instance = new GMailManager();
		}
		
		return instance;
	}
	
	

	@Override
	public FileProcessResponse sendMail(Mail mail)
	{
		System.out.println("LLEGO");
		return null;
	}
	

}
