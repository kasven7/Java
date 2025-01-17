package lab11_p;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;


public class Zad4 {
    public static void main(String[] args) {
        // Sender's email credentials
        final String senderEmail = "112090@g.elearn.uz.zgora.pl";
        final String senderPassword = "password"; // Replace with your actual password


        // Recipient's email
        String recipientEmail = "gandalf1337111@gmail.com"; // Replace with the recipient's email address


        // SMTP server configuration
        String host = "smtp.gmail.com"; // The SMTP server for the UZ email system
        int port = 587; // SMTP port


        // Email message details
        String subject = "Test Email from Java Program";
        String body = "Hello There :)!";


        // Setting up mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true"); // Enable authentication
        properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS
        properties.put("mail.smtp.host", host); // Set SMTP server
        properties.put("mail.smtp.port", String.valueOf(port)); // Set SMTP port


        // Creating a session with an authenticator
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Creating a MIME message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail)); // Sender's email
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail)); // Recipient's email
            message.setSubject(subject); // Subject of the email
            message.setText(body); // Body of the email


            // Sending the email
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Failed to send email. Error: " + e.getMessage());
        }
    }
}
