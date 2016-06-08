package com.test.core;


import org.junit.BeforeClass;
import org.junit.Test;

import com.daloz.factorymail.config.enums.EmailType;
import com.daloz.factorymail.core.IMailManager;
import com.daloz.factorymail.factoryservice.FactoryMailManager;
import com.daloz.factorymail.objects.FileProcessResponse;
import com.daloz.factorymail.objects.EMail;

public class TestGMail
{
	static IMailManager iMailManager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		iMailManager = FactoryMailManager.getMailManager(EmailType.GMAIL);
	}

	@Test
	public void test()
	{
		EMail mail = new EMail();
		mail.setFrom("medikidsm@gmail.com");
		mail.setPassword("ggronxubhzbcdgfg");
		mail.setSubject("Titulo");
		mail.setText("Cuerpo del texto");
		
		mail.setRecipient("cristhianp00@gmail.com", "soharu666@gmail.com");
		mail.setHiddenRecipient("sgirard2080@gmail.com");
		
		FileProcessResponse fr = iMailManager.sendMail(mail);
	}

}
