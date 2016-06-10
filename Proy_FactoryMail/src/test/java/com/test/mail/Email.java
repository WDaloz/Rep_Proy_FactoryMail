package com.test.mail;

public class Email
{
	private String from, subject, text, password;
	private String[] recipient;

	public String getFrom()
	{
		return from;
	}

	public void setFrom(String from)
	{
		this.from = from;
	}

	public String getSubject()
	{
		return subject;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
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

	public String[] getRecipient()
	{
		return recipient;
	}

	public void setRecipient(String... recipient)
	{
		this.recipient = recipient;
	}

}
