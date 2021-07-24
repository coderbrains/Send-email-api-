package com.sendmail.services;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public boolean sendAttachedEmail(String to, String subject, String message) {
		boolean flag = false;
		String from = "dhakarsinghkumar03@gmail.com";

		// variable for the email host...

		String host = "smtp.gmail.com";

		// Get the session object
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, "!@123456789");
			}

		});

		session.setDebug(true);

		// compose the message
		try {
			MimeMessage message1 = new MimeMessage(session);
			message1.setFrom(from);
			message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message1.setSubject(subject);
			
			
			String path = "D:\\new\\ak.jpg";
			
			MimeMultipart mimeMultipart = new MimeMultipart();
			
			MimeBodyPart mPart = new MimeBodyPart();
			
			MimeBodyPart mPart2 = new MimeBodyPart();
			
			
			try {
				
				mPart.setText(message);
				File f = new File(path);
				mPart2.attachFile(f);
				
				mimeMultipart.addBodyPart(mPart2);
				mimeMultipart.addBodyPart(mPart);
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			message1.setContent(mimeMultipart);
			
			

			// Send message
			Transport.send(message1);
			System.out.println("message sent successfully....");

			flag = true;

		} catch (Exception mex) {
			mex.printStackTrace();
		}

		return flag;

	}

	public boolean sendMail(String to, String subject, String message) {
		boolean flag = false;
		String from = "dhakarsinghkumar03@gmail.com";

		// variable for the email host...

		String host = "smtp.gmail.com";

		// Get the session object
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, "!@123456789");
			}

		});

		session.setDebug(true);

		// compose the message
		try {
			MimeMessage message1 = new MimeMessage(session);
			message1.setFrom(from);
			message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message1.setSubject(subject);
			message1.setText(message);

			// Send message
			Transport.send(message1);
			System.out.println("message sent successfully....");

			flag = true;

		} catch (Exception mex) {
			mex.printStackTrace();
		}

		return flag;
	}

}
