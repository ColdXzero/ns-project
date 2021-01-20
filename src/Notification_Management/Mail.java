package Notification_Management;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

import model.Ns_Setting;
import Controller.C_Setting;

public class Mail {

	public static String sendMail( String sendTo, String subject, String text)
	{
		C_Setting c_set = new C_Setting();
		ArrayList<Ns_Setting> list= c_set.GetAll(" s_type=\"mail_user\"");
		if (list==null || list.size()==0) return " Error in Mail User Setting";
		
		final String username = list.get(0).Value;
		
		list=c_set.GetAll(" s_type=\"mail_user_pwd\"");
		if (list==null || list.size()==0) return " Error in Mail User password Setting";
		
		final String password =  list.get(0).Value;
	
	
		Properties props = new Properties();
		MailSSLSocketFactory sf;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			props.put("mail.smtp.ssl.trust", "*");
			props.put("mail.smtp.ssl.socketFactory", sf);
		} catch (GeneralSecurityException e1) {
			
			e1.printStackTrace();
		}
		 
		
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

	Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	    protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication(username, password);
	    }
	});
	try {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(sendTo));
		message.setSubject(subject);
						message.setContent(text,"text/html; charset=utf-8");
								Transport.send(message);


	} catch (MessagingException e) {
		System.out.println(e.getMessage());
		throw new RuntimeException(e);
	}
return "Done dear"	;
	
}
}
