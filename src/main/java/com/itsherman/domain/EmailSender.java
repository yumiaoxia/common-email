package com.itsherman.domain;

import com.itsherman.session.SessionFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

/**
 * <p>邮件发送主体</p>
 *
 * @author 俞淼霞
 * @since 2019-08-15
 */
public class EmailSender implements Serializable {

   private EmailSendInfo emailSendInfo;

   private ControlMailBox controlMailBox;


    public EmailSender() {
    }

    public EmailSender(EmailSendInfo emailSendInfo) {
        this.emailSendInfo = emailSendInfo;
        this.controlMailBox = ControlMailBox.getInstance();
    }

    public void send() {
        Session session = SessionFactory.openSession(emailSendInfo.getUseSSL(),true);
        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailSendInfo.getFrom()));
            message.setText(emailSendInfo.getContent(),"UTF-8");
            message.setSubject(emailSendInfo.getSubject());
            message.setSentDate(Date.from(Instant.now()));
            message.setRecipients(Message.RecipientType.TO,emailSendInfo.getAllRicipients().toArray(new Address[emailSendInfo.getAllRicipients().size()]));
            message.saveChanges();
            Transport transport = session.getTransport();
            transport.connect(controlMailBox.getUsername(),controlMailBox.getPassword());
            transport.sendMessage(message,message.getAllRecipients());
            transport.close();
        }catch (MessagingException e){
            e.printStackTrace();
        }

    }

    public EmailSendInfo getEmailSendInfo() {
        return emailSendInfo;
    }

    public void setEmailSendInfo(EmailSendInfo emailSendInfo) {
        this.emailSendInfo = emailSendInfo;
    }


}
