package com.daloz.factorymail.core.impl;

import static com.daloz.factorymail.config.enums.ProcessMessages.*;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import com.daloz.factorymail.core.IMailManager;
import com.daloz.factorymail.exception.MessageNullException;
import com.daloz.factorymail.exception.RecipientNullException;
import com.daloz.factorymail.objects.FileProcessResponse;
import com.daloz.factorymail.objects.EMail;

import static com.daloz.factorymail.config.properties.PropertiesHelper.*;
import static com.daloz.factorymail.config.enums.EmailType.*;

public class GMailManager implements IMailManager
{
	private static GMailManager instance;
	private Properties properties;

	private GMailManager()
	{
		// Inicilizar las propiedades.
		properties = getProperties(GMAIL.getProperties());
	}

	public static GMailManager getInstance()
	{
		if (instance == null)
		{
			instance = new GMailManager();
		}

		return instance;
	}

	@Override
	public FileProcessResponse sendMail(EMail email)
	{
		FileProcessResponse fPResponse = new FileProcessResponse();

		try
		{

			if (
				email.getHiddenRecipientBCC() == null &&
				email.getRecipientCC() == null && 
				email.getRecipientTO() == null)
			{
				throw new RecipientNullException();
			}
			
			if(email.getText() == null)
			{
				throw new MessageNullException();
			}

			Long startTime = System.nanoTime();

			Session session = Session.getInstance(properties, new Authenticator()
			{
				@Override
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication(email.getFrom(), email.getPassword());
				}
			});

			MimeMessage message = new MimeMessage(session);


			message.setRecipients(RecipientType.TO, email.getRecipientTO());
			message.setRecipients(RecipientType.BCC, email.getHiddenRecipientBCC());
			message.setRecipients(RecipientType.CC, email.getRecipientCC());

			message.setSubject(email.getSubject());

			if (email.getHtml())
			{
				message.setContent(email.getText(), "text/html");
			}
			else
			{
				message.setText(email.getText());
			}

			Transport.send(message);

			Long endTime = System.nanoTime();

			fPResponse.generatingMappingSatisfactory(EMAIL_SENT_MSG.getMessage(), startTime, endTime);

		}
		catch (MessagingException | RecipientNullException | MessageNullException e)
		{
			fPResponse.generatingMappingErrors(e);
			e.printStackTrace();
		}

		return fPResponse;
	}

}
