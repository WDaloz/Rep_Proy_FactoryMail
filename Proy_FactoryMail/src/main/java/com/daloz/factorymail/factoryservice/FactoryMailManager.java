package com.daloz.factorymail.factoryservice;

import com.daloz.factorymail.config.enums.EmailType;
import com.daloz.factorymail.core.IMailManager;
import com.daloz.factorymail.core.impl.GenericMailManager;

public abstract class FactoryMailManager
{
	public static IMailManager getGenericMailManager(EmailType emailType)
	{
		return GenericMailManager.getInstance(emailType);
	}
}
