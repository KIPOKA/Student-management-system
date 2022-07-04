 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.mail;
 
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;

/**
 *
 * @author 27611
 */
//@ServletSecurity(@HttpConstraint(rolesAllowed={"admin"}))
public class SendMail {
    
    public boolean sendEmail(UserEmail user){
        boolean test=false;
       
            String toEmail = user.getEmail();
            String text = user.getText();
            // get the email string
            final String fromEmail ="itechgroup21@gmail.com";
            final String password = "c'est la vie!";
        try { 
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smtp.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.socketFactory.port", "587");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            
            Session session = Session.getInstance(pr, new Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(fromEmail, password);
                }
            });
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject("i-Tech project group");
            msg.setContent(text, "text/html");
            Transport.send(msg);
            test = true; 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return test;
    }
    
}
