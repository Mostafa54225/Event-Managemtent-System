/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.MalformedURLException;
import java.util.Properties;
/**
 *
 * @author Khalifa
 */
public class MailSender {
    
    public static boolean sendMail(String to,String messageBody)
    {
        String from = "thegreat7oda@gmail.com";                          //sender e-mail
        String password = "hoppaeshtagangamstyle";                       //sender password
        Properties properties = new Properties();                        //create object from properties class to set protocol properties
        properties.put("mail.smtp.auth", "true");                        //always true
        properties.put("mail.smtp.starttls.enable", "true");             //always true
        properties.put("mail.smtp.host", "smtp.gmail.com");              //sender mail's host
        properties.put("mail.smtp.port", "587");                         //sender mail's port
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }                                                           //holds email and password of sender to use it
        });

        try {
            MimeMessage message = new MimeMessage(session);             //make object from message of the session that we made above
            message.setFrom(new InternetAddress(from));                 //set sender (from)
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));     //set receiver
            message.setSubject("your reservation information");                //set e-mail subject
            message.setText(messageBody);      //set e-mail content (message)
            Transport.send(message);                                    //sends the message
            return true;

        } catch (MessagingException mex) {
            //mex.printStackTrace();
            return false;
        }
    }
}
