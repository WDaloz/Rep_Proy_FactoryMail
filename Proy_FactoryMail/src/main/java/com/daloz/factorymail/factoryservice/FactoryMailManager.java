package com.daloz.factorymail.factoryservice;

import com.daloz.factorymail.config.enums.EmailType;
import com.daloz.factorymail.core.IMailManager;
import com.daloz.factorymail.core.impl.GMailManager;
import com.daloz.factorymail.core.impl.OutlookManager;

public abstract class FactoryMailManager
{
	public static IMailManager getMailManager(EmailType emailType)
	{
		switch (emailType)
		{
			
			case GMAIL:
				return  GMailManager.getInstance();
				
			case OUTLOOK:

				return  OutlookManager.getInstance();

			default:
				return null;
		}
	}
}
