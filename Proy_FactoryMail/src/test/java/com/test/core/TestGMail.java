package com.test.core;


import org.junit.BeforeClass;
import org.junit.Test;

import com.daloz.factorymail.config.enums.EmailType;
import com.daloz.factorymail.core.IMailManager;
import com.daloz.factorymail.factoryservice.FactoryMailManager;
import com.daloz.factorymail.objects.FileProcessResponse;
import com.daloz.factorymail.objects.Mail;

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
		Mail mail = new Mail();
		mail.setFrom("cristhianp00@gmail.com");
		mail.setSubject("Titulo");
		mail.setText("Cuerpo del texto");
		mail.setRecipient("cristhianp00@gmail.com");
		
		FileProcessResponse fr = iMailManager.sendMail(mail);
	}

}
