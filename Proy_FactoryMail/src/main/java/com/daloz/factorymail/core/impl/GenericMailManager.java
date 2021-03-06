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

import com.daloz.factorymail.config.enums.EmailType;
import com.daloz.factorymail.core.IMailManager;
import com.daloz.factorymail.dataobjects.Email;
import com.daloz.factorymail.dataobjects.FileProcessResponse;
import com.daloz.factorymail.exception.MessageNullException;
import com.daloz.factorymail.exception.RecipientNullException;

import static com.daloz.factorymail.config.properties.PropertiesHelper.*;
import static com.daloz.factorymail.config.enums.EmailType.*;

public class GenericMailManager implements IMailManager
{
	private static GenericMailManager instanceGmail, instanceOutlook;
	private static Properties properties;

	private GenericMailManager(String path)
	{
		// Inicilizar las propiedades.
		properties = getProperties(path);
	}

	public static GenericMailManager getInstance(EmailType emailType, Integer port)
	{
		if (emailType == GMAIL)
		{
			if (instanceGmail == null)
			{
				instanceGmail = new GenericMailManager(emailType.getPath());
				if(port != null)
				{
					System.out.println("Llego para establecer puerto: "+port);
					properties.setProperty("mail.smtp.port", port.toString());
				}
			}

			return instanceGmail;
		}

		if (instanceOutlook == null)
		{
			instanceOutlook = new GenericMailManager(emailType.getPath());
		}

		return instanceOutlook;
	}

	@Override
	public FileProcessResponse sendMail(final Email email)
	{
		FileProcessResponse fPResponse = new FileProcessResponse();

		try
		{

			if (email.getHiddenRecipientBCC() == null && email.getRecipientCC() == null
					&& email.getRecipientTO() == null)
			{
				throw new RecipientNullException();
			}

			if (email.getText() == null)
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

			System.out.println("Enviado desd el puerto: "+properties.getProperty("mail.smtp.port"));
		}
		catch (MessagingException | RecipientNullException | MessageNullException e)
		{
			fPResponse.generatingMappingErrors(e);
			e.printStackTrace();
		}

		return fPResponse;
	}
	
	public void setProperties(Properties properties)
	{
		GenericMailManager.properties = properties;
	}

}
