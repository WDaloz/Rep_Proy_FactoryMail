package com.daloz.factorymail.core.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import com.daloz.factorymail.core.IMailManager;
import com.daloz.factorymail.objects.FileProcessResponse;
import com.daloz.factorymail.objects.EMail;

public class GMailManager implements IMailManager
{
	private static GMailManager instance;
	private Properties properties;

	private GMailManager()
	{
		initProperties();
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
		FileProcessResponse fResponse = new FileProcessResponse();

		Session session = Session.getInstance(properties, new Authenticator()
		{
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(email.getFrom(), email.getPassword());
			}
		});

		MimeMessage message = new MimeMessage(session);

		try
		{
			message.setRecipients(RecipientType.TO, email.getRecipient());
			message.setRecipients(RecipientType.BCC, email.getHiddenRecipient());

			message.setSubject(email.getSubject());
			message.setText(email.getText());

			Transport.send(message);

		} catch (MessagingException e)
		{
			e.printStackTrace();
		}

		return fResponse;
	}

	private void initProperties()
	{
		properties = new Properties();

		// Esta propiedad representa el host que hace de servidor de correo.
		// En este caso para el servidor de gmail.
		properties.put("mail.smtp.host", "smtp.gmail.com");

		// TLS si esta disponible en el servidor se activara.
		// Sirve para el envio de informacion encriptada.
		properties.put("mail.smtp.starttls.enable", "true");

		// Puerto de Gmail en este caso para enviar correos
		properties.put("mail.smtp.port", "587");

		// Establecer cuenta de correo a usar como emisor.
		// properties.put("mail.smtp.mail.sender", email.getFrom());

		// Establece la propiedad que si requiere o no auntenticacion
		// En este caso si se requiere
		properties.put("mail.smtp.auth", "true");
	}

}
