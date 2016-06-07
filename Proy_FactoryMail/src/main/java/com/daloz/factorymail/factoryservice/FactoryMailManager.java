package com.daloz.factorymail.factoryservice;

import com.daloz.factorymail.config.enums.EmailType;
import com.daloz.factorymail.core.IMailManager;
import com.daloz.factorymail.core.impl.GMailManager;

public abstract class FactoryMailManager
{
	public static IMailManager getMailManager(EmailType emailType)
	{
		switch (emailType)
		{
			case GMAIL:
				return  GMailManager.getInstance();

			default:
				return null;
		}
	}
}
