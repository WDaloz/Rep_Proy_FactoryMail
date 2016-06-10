package com.daloz.factorymail.objects;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EMail
{
	private Boolean html;
	private String from, subject, text, password;
	private InternetAddress[] recipientTO, hiddenRecipientBCC, recipientCC;

	public String getFrom()
	{
		return from;
	}

	public InternetAddress[] getHiddenRecipientBCC()
	{
		return hiddenRecipientBCC;
	}

	public void setHiddenRecipientBCC(String... hiddenRecipientBCC)
	{
		this.hiddenRecipientBCC = new InternetAddress[hiddenRecipientBCC.length];

		for (int i = 0; i < hiddenRecipientBCC.length; i++)
		{
			try
			{
				this.hiddenRecipientBCC[i] = new InternetAddress(hiddenRecipientBCC[i]);
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
		this.html = false;
	}
	public void setTextHtml(String text)
	{
		this.text = text;
		this.html =  true;
	}
	

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public InternetAddress[] getRecipientTO()
	{
		return recipientTO;
	}

	public void setRecipientTO(String... recipientTO)
	{
		this.recipientTO = new InternetAddress[recipientTO.length];

		for (int i = 0; i < recipientTO.length; i++)
		{
			try
			{
				this.recipientTO[i] = new InternetAddress(recipientTO[i]);
			} catch (AddressException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public Boolean getHtml()
	{
		return html;
	}

	public InternetAddress[] getRecipientCC()
	{
		return recipientCC;
	}

	public void setRecipientCC(String... recipientCC)
	{
		this.recipientCC = new InternetAddress[recipientCC.length];

		for (int i = 0; i < recipientCC.length; i++)
		{
			try
			{
				this.recipientCC[i] = new InternetAddress(recipientCC[i]);
			} 
			catch (AddressException e)
			{
				e.printStackTrace();
			}
		}
	}
 
}
