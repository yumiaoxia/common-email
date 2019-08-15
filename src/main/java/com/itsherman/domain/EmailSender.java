package com.itsherman.domain;

import com.itsherman.config.ServerConfig;
import com.itsherman.constant.PopKeyConstants;
import com.itsherman.session.SessionFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * <p>邮件发送主体</p>
 *
 * @author 俞淼霞
 * @since 2019-08-15
 */
public class EmailSender implements Serializable {

   private EmailSendInfo emailSendInfo;


    public EmailSender() {
    }

    public EmailSender(EmailSendInfo emailSendInfo) {
        this.emailSendInfo = emailSendInfo;
    }

    public void send() {
        Session session = SessionFactory.openSession(emailSendInfo.getUseSSL(),emailSendInfo.getAuth());
        try {
            Transport transport = session.getTransport();
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailSendInfo.getFrom()));
            message.setText(emailSendInfo.getContent(),"UTF-8");
            message.setSubject(emailSendInfo.getSubject());
            message.setSentDate(Date.from(Instant.now()));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(emailSendInfo.getToUsers().get(0).getEmailAddress()));
            transport.connect("yumiaoxia132@163.com","yuzi940710");
            transport.sendMessage(message,message.getRecipients(Message.RecipientType.TO));
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
