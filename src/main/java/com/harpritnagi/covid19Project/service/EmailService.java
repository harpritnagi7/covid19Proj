package com.harpritnagi.covid19Project.service;

import javax.mail.Session;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import org.springframework.stereotype.Service;



@Service
public class EmailService {
    public boolean sendEmail(String subject, String message, String to) {
    	boolean f = false;
    	
    
    	// Recipient's email ID needs to be mentioned.
       

        // Sender's email ID needs to be mentioned
        String from = "myselfharpritsingh@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
    	
//    Step 1 to get the session object
    	
    	Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("myselfharpritsingh@gmail.com", "abcdgmail");
    }
    
    	
    });
    	
    	session.setDebug(true);
    	
    	//step2 compose the message [text multi media]
    	MimeMessage m = new MimeMessage(session);
    	
    	try {
    	//from email
    		
    	m.setFrom(from);
    	
    	//adding reciptent to message
    	m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    	
    	//adding subject to message
    	m.setSubject(subject);
    	
    	//adding text to message
    //	m.setText(message);
	m.setContent(message,"text/html");
    	
    	//send
    	
    	//step 3 : send the message using spring Transport class
    	Transport.send(m);
    	
    	System.out.println("Sent success.....");
    	f=true;
    
    } catch(Exception e) {
    	e.printStackTrace();
    
    } 
    return f;
	
    }
}
