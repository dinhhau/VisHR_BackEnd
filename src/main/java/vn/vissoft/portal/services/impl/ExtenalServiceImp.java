package vn.vissoft.portal.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.entities.ExtenalNotify;
import vn.vissoft.portal.entities.TimeOff;
import vn.vissoft.portal.repositories.ExtenalRepository;
import vn.vissoft.portal.services.ExtenalService;
import vn.vissoft.portal.services.TimeOffService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class ExtenalServiceImp implements ExtenalService {

    private static final Logger LOG = LoggerFactory.getLogger(ExtenalServiceImp.class);

    @Autowired
    private ExtenalRepository extenalRepository;

    @Autowired
    private TimeOffService timeOffService;

    @Override
    public void sendMail(TimeOff timeOff, String subject, String text, String[] to, List<String> cc) {

        String host = "mail.vissoft.vn";
        final String user = "vis_hr.alert@vissoft.vn";
        final String password = "123456a@";

        //Get the session Object
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.allow8bitmime", "true");
        props.setProperty("mail.smtps.allow8bitmime", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication
                    getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        try {
            InternetAddress[] sendTo = new InternetAddress[to.length];
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            // To get the array of sendTo
            for( int i = 0; i < to.length; i++ ) {
                sendTo[i] = new InternetAddress(to[i]);
            }

            // Set To: header field of the header.
            for( int i = 0; i <sendTo.length; i++) {
                message.addRecipient(Message.RecipientType.TO, sendTo[i]);
            }

            InternetAddress[] sendCC = new InternetAddress[cc.size()];
            // To get the array of sendCC
            for( int i = 0; i < cc.size(); i++ ) {
                sendCC[i] = new InternetAddress(cc.get(i));
            }

            // Set cc: header field of the header.
            for( int i = 0; i < sendCC.length; i++) {
                message.addRecipient(Message.RecipientType.CC, sendCC[i]);
            }

            message.setSubject(subject);
            message.setContent(text, "text/html");

            Transport.send(message);

        } catch (MessagingException e) {
            LOG.error(e.toString());
        }
    }

    @Override
    public void sendMailWarring(TimeOff timeOff, String subject, String text, String[] to) {

        String host = "mail.vissoft.vn";
        final String user = "vis_hr.alert@vissoft.vn";
        final String password = "123456a@";

        //Get the session Object
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.allow8bitmime", "true");
        props.setProperty("mail.smtps.allow8bitmime", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication
                    getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        try {
            InternetAddress[] sendTo = new InternetAddress[to.length];
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            // To get the array of sendTo
            for( int i = 0; i < to.length; i++ ) {
                sendTo[i] = new InternetAddress(to[i]);
            }

            // Set To: header field of the header.
            for( int i = 0; i <sendTo.length; i++) {
                message.addRecipient(Message.RecipientType.TO, sendTo[i]);
            }

            message.setSubject(subject);
            message.setContent(text, "text/html");

            Transport.send(message);

        } catch (MessagingException e) {
            LOG.error(e.toString());
        }
    }

    @Override
    public ExtenalNotify createExtenal(TimeOff timeOff, String content, int status) throws ParseException {

        ExtenalNotify extenalNotify = new ExtenalNotify();

        extenalNotify.setEnTimeOff(timeOff);
        extenalNotify.setEnSendDate(timeOffService.convertToUTC(new Date()));
        extenalNotify.setEnStatus(status);
        extenalNotify.setEnType(1);

        extenalNotify.setEnContent(content);

        return extenalRepository.save(extenalNotify);
    }

    @Override
    public void mailResetPassword(String text, String subject, String[] to) {
        String host = "mail.vissoft.vn";
        final String user = "vis_hr.alert@vissoft.vn";
        final String password = "123456a@";

        //Get the session Object
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.allow8bitmime", "true");
        props.setProperty("mail.smtps.allow8bitmime", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication
                    getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        try {
            InternetAddress[] sendTo = new InternetAddress[to.length];
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            // To get the array of sendTo
            for( int i = 0; i < to.length; i++ ) {
                sendTo[i] = new InternetAddress(to[i]);
            }

            // Set To: header field of the header.
            for( int i = 0; i <sendTo.length; i++) {
                message.addRecipient(Message.RecipientType.TO, sendTo[i]);
            }

            message.setSubject(subject);
            message.setContent(text, "text/html");

            Transport.send(message);

        } catch (MessagingException e) {
            LOG.error(e.toString());
        }
    }

    @Override
    public void sendMailEvaluateKPI(String text, String subject, String[] to) {
        String host = "mail.vissoft.vn";
        final String user = "vis_hr.alert@vissoft.vn";
        final String password = "123456a@";

        //Get the session Object
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.allow8bitmime", "true");
        props.setProperty("mail.smtps.allow8bitmime", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication
                    getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        try {
            InternetAddress[] sendTo = new InternetAddress[to.length];
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            // To get the array of sendTo
            for( int i = 0; i < to.length; i++ ) {
                sendTo[i] = new InternetAddress(to[i]);
            }

            // Set To: header field of the header.
            for( int i = 0; i <sendTo.length; i++) {
                message.addRecipient(Message.RecipientType.TO, sendTo[i]);
            }

            message.setSubject(subject);
            message.setContent(text, "text/html");

            Transport.send(message);

        } catch (MessagingException e) {
            LOG.error(e.toString());
        }
    }
}
