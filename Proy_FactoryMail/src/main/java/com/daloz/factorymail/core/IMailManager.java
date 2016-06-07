package com.daloz.factorymail.core;

import com.daloz.factorymail.objects.FileProcessResponse;
import com.daloz.factorymail.objects.Mail;

public interface IMailManager
{
	FileProcessResponse sendMail(Mail mail);
}
