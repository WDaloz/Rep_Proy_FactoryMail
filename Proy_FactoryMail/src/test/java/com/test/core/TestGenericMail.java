package com.test.core;

import org.junit.Ignore;
import org.junit.Test;

import com.daloz.factorymail.config.enums.EmailType;
import com.daloz.factorymail.core.IMailManager;
import com.daloz.factorymail.dataobjects.Email;
import com.daloz.factorymail.dataobjects.FileProcessResponse;
import com.daloz.factorymail.factoryservice.FactoryMailManager;

public class TestGenericMail
{
	static IMailManager iMailManager;



	@Test
	public void testGmail()
	{
		iMailManager = FactoryMailManager.getGenericMailManager(EmailType.GMAIL);

		Email mail = new Email();
		mail.setFrom("medikidsm@gmail.com");
		mail.setPassword("ggronxubhzbcdgfg");
		mail.setSubject("Titulo");
		mail.setTextHtml("<h1>body gmail object</h1><p>it's a simple test</p>");

		mail.setRecipientTO("cristhianp00@gmail.com");
	

		FileProcessResponse fr = iMailManager.sendMail(mail);

		System.out.println(fr.getReport());
	}
	
	@Ignore
	@Test
	public void testOutlook()
	{
		iMailManager = FactoryMailManager.getGenericMailManager(EmailType.OUTLOOK);

		Email mail = new Email();
		mail.setFrom("medikidsm@gmail.com");
		mail.setPassword("ggronxubhzbcdgfg");
		mail.setSubject("Titulo");
		mail.setTextHtml("<h1>body gmail object</h1><p>it's a simple test</p>");

		mail.setRecipientTO("cristhianp00@gmail.com");
		mail.setHiddenRecipientBCC("sgirard2080@gmail.com");
		mail.setRecipientCC("soharu666@gmail.com");

		FileProcessResponse fr = iMailManager.sendMail(mail);

		System.out.println(fr.getReport());
	}

}
