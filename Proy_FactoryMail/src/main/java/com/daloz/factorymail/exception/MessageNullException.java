package com.daloz.factorymail.exception;

@SuppressWarnings("serial")
public class MessageNullException extends Exception
{
	public MessageNullException()
	{
		super("Contenido del mensaje es nulo, ingresar mensaje");
	}
}
