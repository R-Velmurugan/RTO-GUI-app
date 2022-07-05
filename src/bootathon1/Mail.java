package bootathon1;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class Mail{
	public Mail(String mail,String reason) throws Exception{

		final String username = <your mail>;
		final String password = <mail password>;

                final String from = <your mail>;
                final String to = mail;

		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");



                Authenticator a=new Authenticator()
                {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }

                };

                Session session = Session.getInstance(props, a);

  //2) compose message
  try{
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
    message.setSubject("Application rejected");

    //3) create MimeBodyPart object and set your message content
    BodyPart messageBodyPart1 = new MimeBodyPart();
    messageBodyPart1.setText("Your application has been rejected due to "+reason+"\n"+"You can view your application below:");

    //4) create new MimeBodyPart object and set DataHandler object to this object
    MimeBodyPart messageBodyPart2 = new MimeBodyPart();

    String filename = "C:\\Users\\rvelm\\eclipse-workspace\\bootathon1\\Application.pdf";//change accordingly
    DataSource source = new FileDataSource(filename);
    messageBodyPart2.setDataHandler(new DataHandler(source));
    messageBodyPart2.setFileName(filename);


    //5) create Multipart object and add MimeBodyPart objects to this object
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart1);
    multipart.addBodyPart(messageBodyPart2);

    //6) set the multiplart object to the message object
    message.setContent(multipart);

    //7) send message
    Transport.send(message);

   System.out.println("message sent....");
   }catch (MessagingException ex) {
       
       
	}}
	
	public Mail(String mail) {

		final String username = <your mail>;
		final String password = <mail password>;

                final String username = <your mail>;
                final String to = mail;

		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");



                Authenticator a=new Authenticator()
                {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }

                };

                Session session = Session.getInstance(props, a);

  //2) compose message
  try{
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
    message.setSubject("Application accepted");

    //3) create MimeBodyPart object and set your message content
    BodyPart messageBodyPart1 = new MimeBodyPart();
    messageBodyPart1.setText("Your application has been approved."+"\n"+"You can view your application below:");

    //4) create new MimeBodyPart object and set DataHandler object to this object
    MimeBodyPart messageBodyPart2 = new MimeBodyPart();

    String filename = "C:\\Users\\rvelm\\eclipse-workspace\\bootathon1\\Application.pdf";//change accordingly
    DataSource source = new FileDataSource(filename);
    messageBodyPart2.setDataHandler(new DataHandler(source));
    messageBodyPart2.setFileName(filename);


    //5) create Multipart object and add MimeBodyPart objects to this object
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart1);
    multipart.addBodyPart(messageBodyPart2);

    //6) set the multiplart object to the message object
    message.setContent(multipart);

    //7) send message
    Transport.send(message);

   System.out.println("message sent....");
   }catch (MessagingException ex) {
       
       
	}}
}