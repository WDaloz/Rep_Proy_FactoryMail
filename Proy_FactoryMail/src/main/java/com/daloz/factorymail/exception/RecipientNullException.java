package com.daloz.factorymail.exception;

@SuppressWarnings("serial")
public class RecipientNullException extends Exception
{
	public RecipientNullException()
	{
		super("Recipientes del mensaje son nulos, se necesitan al menos un recipiente");
	}
}
