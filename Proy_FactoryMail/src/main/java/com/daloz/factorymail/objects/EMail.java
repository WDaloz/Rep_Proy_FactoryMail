package com.daloz.factorymail.objects;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EMail
{
	private String from, subject, text, password;
	private InternetAddress[] recipient, hiddenRecipient;

	public String getFrom()
	{
		return from;
	}

	public InternetAddress[] getHiddenRecipient()
	{
		return hiddenRecipient;
	}

	public void setHiddenRecipient(String... hiddenRecipient)
	{
		this.hiddenRecipient = new InternetAddress[hiddenRecipient.length];

		for (int i = 0; i < hiddenRecipient.length; i++)
		{
			try
			{
				this.hiddenRecipient[i] = new InternetAddress(hiddenRecipient[i]);
			} 
			catch (AddressException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void setFrom(String from)
	{
		this.from = from;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public InternetAddress[] getRecipient()
	{
		return recipient;
	}

	public void setRecipient(String... recipient)
	{
		this.recipient = new InternetAddress[recipient.length];

		for (int i = 0; i < recipient.length; i++)
		{
			try
			{
				this.recipient[i] = new InternetAddress(recipient[i]);
			} catch (AddressException e)
			{
				e.printStackTrace();
			}
		}
	}

}
