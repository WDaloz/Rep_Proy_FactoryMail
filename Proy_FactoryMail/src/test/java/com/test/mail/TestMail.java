package com.test.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestMail
{
	static Email email = new Email();

	@BeforeClass
	public static void beforeClass()
	{
		email.setFrom("medikidsm@gmail.com");
		email.setRecipient("cristhsianp00@gmail.com");
		email.setSubject("Asunto de prueba");
		email.setText("Mensaje");
		email.setPassword("ggronxubhzbcdgfg");
	}

	
	@Test
	public  void testGmail()
	{
		/**
		 * 
		 * La configuración de esta cuenta (de cualquier cuenta de gmail) para el envío de correos es
		 * Requiere usuario y password. El usuario es la cuenta de correo, pondremos por ejemplo, ejemplo@gmail.com
		 * Protocolo smtp
		 * TLS si está disponible
		 * Puerto 587, que no es el de defecto de smtp.
		 */
		
		// Propiedades para el envio de correo mediante GMail
		// Esta clase sirve para inyectar clave y valor.

		Properties properties = new Properties();

		// Esta propiedad representa el host que hace de servidor de correo.
		properties.put("mail.smtp.host", "smtp.gmail.com");

		// TLS si esta disponible en el servidor se activara.
		// Sirve para el envio de informacion encriptada.
		properties.put("mail.smtp.starttls.enable", "true");

		// Puerto de Gmail en este caso para enviar correos
		properties.put("mail.smtp.port", "587");

		// Establecer cuenta de correo a usar como emisor.
		properties.put("mail.smtp.mail.sender", email.getFrom());
		
		//Establece la propiedad que si requiere o no auntenticacion por password.
		properties.put("mail.smtp.auth", "true");

		// Estableciendo password del correo emisor.
		properties.put("mail.smtp.password", email.getPassword());

		
		//Usuario quien reliza la conexion.
		properties.put("mail.smtp.user", email.getFrom());
		
		
		
		/**
		 * Session: Clase que representa la conexion a un servidor de correo,
		 *          recibe como parametro las propiedades de configuracion y opcional
		 *          la implementacion de la clase Auntenticator.
		 *          
		 */
		Session session = Session.getInstance(properties);
		
//		session.setDebug(true);
		
		/**
		 * Clase para los mensajes, recibe como parametro la session.
		 */
		MimeMessage message = new MimeMessage(session);
		
		try
		{
			//Inyectamos el valor de quien va a enviar el correo.
			//Recibe como parametro
			message.setFrom(
					         new InternetAddress
					                  (
					        		  (String)properties.get("mail.smtp.mail.sender")
					        		  )
					       );
			
			//Añadiendo recipienes
			/**
			 * message.addRecipient()
			 * 
			 */
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("cristhianp00@gmail.com"));
			
			message.setSubject("Roxanita");
			message.setText("I Love You Forever");
			
			
			Transport t = session.getTransport("smtp");
			t.connect((String)properties.getProperty("mail.smtp.user"), (String)properties.getProperty("mail.smtp.password"));
			
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			
		} 
		catch (MessagingException e)
		{
			e.printStackTrace();
		}

	}
	
	@Ignore
	@Test
	public void test2()
	{
		Properties propiedades = new Properties();
		propiedades.put("mail.smtp.auth", "true");
		propiedades.put("mail.smtp.starttls.enable", "true");
		propiedades.put("mail.smtp.host", "smtp.gmail.com");
		propiedades.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(propiedades,new javax.mail.Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication() 
					{
						return new PasswordAuthentication("medikidsm@gmail.com", "ggronxubhzbcdgfg");
					}
				  });
		
		try
		{
 
			Message message = new MimeMessage(session);
			
			//El emisor
			message.setFrom(new InternetAddress("medikidsm@gmail.com"));
			
			//El receptor
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("cristhianp00@gmail.com"));
			message.setSubject("Asunto prueba");
			message.setText("Texto prueba");
 
			Transport.send(message);
			
            
		} 
		catch (MessagingException e) 
		{
			System.out.println("Error al enviar correo ---> "+e);
			throw new RuntimeException(e);
		}
	}
	
	
	@Ignore
	@Test
	public void test3()
	{
		Properties properties = new Properties();
		     Session session;


		        properties.put("mail.smtp.host", "smtp.gmail.com");
		        properties.put("mail.smtp.starttls.enable", "true");
		        properties.put("mail.smtp.port", 587);
		        properties.put("mail.smtp.mail.sender", "medikidsm@gmail.com");
		        properties.put("mail.smtp.password", "ggronxubhzbcdgfg");
		        properties.put("mail.smtp.user", "medikidsm@gmail.com");
		        properties.put("mail.smtp.auth", "true");
		        session = Session.getDefaultInstance(properties);

		        try 
		        {
		            MimeMessage message = new MimeMessage(session);
		            
		            message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
		            message.addRecipient(Message.RecipientType.TO, new InternetAddress("cristhianp00@gmail.com"));
		            message.setSubject("prueba");
		            message.setText("mensajito");
		            
		            Transport t = session.getTransport("smtp");
		            t.connect((String) properties.get("mail.smtp.user"), (String) properties.get("mail.smtp.password"));
		            t.sendMessage(message, message.getAllRecipients());
		            t.close();
		        } 
		        catch (MessagingException e) 
		        {
		            return;
		        }
		    
	}

}
