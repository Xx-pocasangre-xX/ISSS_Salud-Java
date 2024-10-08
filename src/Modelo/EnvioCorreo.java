package Modelo;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnvioCorreo {
    
    public static void envioCorreo(String recipient, String subject, String content) {
        
        //1- Propiedades del servidor de correo
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com"); 
        properties.put("mail.smtp.port", "587");

        
        
        //2- Credenciales de la cuenta de correo
        final String myAccountEmail = "issssaludteam@gmail.com";
        final String password = "x x q n t k b m a h m a y y w c";

        // Crear sesión
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        //3- Enviar el correo
        try {
            // Crear mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(content);

            // Enviar mensaje
            Transport.send(message);
            System.out.println("Correo enviado con éxito");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    } 
}
