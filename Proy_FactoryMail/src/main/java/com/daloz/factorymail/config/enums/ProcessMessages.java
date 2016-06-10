package com.daloz.factorymail.config.enums;

public enum ProcessMessages
{
	EMAIL_SENT_MSG("Correo electronico(s) enviado correctamente");
	
	private String message;
	
	private ProcessMessages(String message)
	{
		this.message = message;
	}
	
	 public String getMessage()
	 {
		 return message;
	 }
}
