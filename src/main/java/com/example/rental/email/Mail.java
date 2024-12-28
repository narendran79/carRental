package com.example.rental.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class Mail {

	Logger log = LoggerFactory.getLogger(Mail.class);
	
	private  JavaMailSender mailSender;
	
	public Mail(JavaMailSender mailSender) {
		this.mailSender=mailSender;
	}
	
	public void sendEmail(String to, String body, String subject) {
	   MimeMessage mimeMessage = mailSender.createMimeMessage();
	   try {
		   MimeMessageHelper message = new MimeMessageHelper(mimeMessage,"utf-8");
		   message.setTo(to);
		   message.setSubject(subject);
		   message.setText(body);
		   mailSender.send(mimeMessage);
		   log.info("Email send successfully");
	   }catch(MessagingException e) {
		   log.error("Error while sending mail" + e);
	   }
	}
}
