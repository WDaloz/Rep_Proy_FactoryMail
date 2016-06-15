package com.daloz.factorymail.core;

import com.daloz.factorymail.dataobjects.Email;
import com.daloz.factorymail.dataobjects.FileProcessResponse;

public interface IMailManager
{
	FileProcessResponse sendMail(Email mail);
}
