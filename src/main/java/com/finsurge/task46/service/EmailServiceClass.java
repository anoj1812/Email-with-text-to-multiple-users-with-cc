package com.finsurge.task46.service;

import com.finsurge.task46.repository.EmailRepository;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finsurge.task46.entity.Email;

@Service
public class EmailServiceClass implements EmailService {
    @Autowired
    private EmailRepository emailRepository;

    public void saveEmail(Email email) {
        emailRepository.save(email);
    }
    @Override
    public void sendMail() throws AddressException, MessagingException, IOException,AuthenticationFailedException {
        Email email=emailRepository.getEmail();
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("< ur mail id >", "< ur password >");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("< ur mail id >", false));
        Set<String> to=email.getEmailTo();
        String str1="";
        for(String t:to)
        {
            str1+=t+",";
        }
        System.out.println(str1);
        msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(str1));
        Set<String> cc=email.getEmailCc();
        String str2="";
        for(String c:cc)
        {
            str2+=c+",";
        }
        System.out.println(str2);
        msg.addRecipients(Message.RecipientType.CC, InternetAddress.parse(str2));
        Set<String> bcc=email.getEmailBcc();
        String str3="";
        for(String bc:bcc)
        {
            str3+=bc+",";
        }
        System.out.println(str3);
        msg.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(str3));
        msg.setSubject(email.getEmailSub());
        String content=email.getEmailmsg();
        msg.setContent(content,"text/plain");
        msg.setSentDate(new Date());
        Transport.send(msg);
    }
}

