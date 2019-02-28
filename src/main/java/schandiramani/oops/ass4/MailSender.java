package schandiramani.oops.ass4;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {
    private static final String FROM = "cs635.822131577@gmail.com";
    private static final String MAIL_SMTP_HOST = "smtp.gmail.com";
    private static final String MAIL_DEBUG = "false";
    private static final String MAIL_SMTP_AUTH = "true";
    private static final String MAIL_SMTP_PORT = "587";
    private static final String MAIL_SMTP_STARTTLS_ENABLE = "true";
    private static final String PASSWORD = "Test@635";
    private static final String MAIL_SUBJECT = "CS635 : Course website updated";

    public static void send(String observer, WebPage webPage, String mailTo) {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", MAIL_SMTP_HOST);
        properties.setProperty("mail.debug", MAIL_DEBUG);
        properties.setProperty("mail.smtp.auth", MAIL_SMTP_AUTH);
        properties.setProperty("mail.smtp.port", MAIL_SMTP_PORT);
        properties.setProperty("mail.smtp.starttls.enable", MAIL_SMTP_STARTTLS_ENABLE);

        try {
            Authenticator authenticator = new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(FROM, PASSWORD);
                }
            };
            Session session = Session.getInstance(properties, authenticator);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
            message.setSubject(MAIL_SUBJECT);
            message.setText(webPage.getWebUrl() + " Changed at : " + webPage.getChangedDate());
            Transport.send(message);
            System.out.println(observer + " sent successfully !!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
