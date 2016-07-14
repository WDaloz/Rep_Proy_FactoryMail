package com.daloz.factorymail.factoryservice;

import com.daloz.factorymail.config.enums.EmailType;
import com.daloz.factorymail.core.IMailManager;
import com.daloz.factorymail.core.impl.GenericMailManager;

public abstract class FactoryMailManager
{
	public static IMailManager getGenericMailManager(EmailType emailType, Integer port)
	{
		return GenericMailManager.getInstance(emailType, port);
	}
}
