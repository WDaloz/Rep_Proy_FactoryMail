package com.daloz.factorymail.core;

import com.daloz.factorymail.objects.FileProcessResponse;
import com.daloz.factorymail.objects.EMail;

public interface IMailManager
{
	FileProcessResponse sendMail(EMail mail);
}
