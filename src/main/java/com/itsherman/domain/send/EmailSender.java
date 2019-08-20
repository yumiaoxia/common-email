package com.itsherman.domain.send;

import com.itsherman.constant.enums.SendType;
import com.itsherman.domain.ControlMailBox;
import com.itsherman.domain.ResultMsg;
import com.itsherman.domain.send.simple.DefaultEmailMessage;
import com.itsherman.session.SessionFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>邮件发送主体</p>
 *
 * @author 俞淼霞
 * @since 2019-08-15
 */
public class EmailSender implements Serializable {
    private static EmailSender emailSender;

   private AbstractEmailMessage emailMessage;

   private static ControlMailBox controlMailBox = ControlMailBox.getInstance();

   private EmailSender(){

   }

   public static synchronized EmailSender getInstance(){
       if(emailSender == null){
           synchronized (EmailSender.class){
               if(emailSender == null){
                   emailSender = new EmailSender();
               }
           }
       }
       return emailSender;
   }

    public ResultMsg send(SendType sendType) {
        ResultMsg resultMsg = new ResultMsg("Email Sending",false,"exception","Unknown Exception");
        Session session = SessionFactory.openSession(emailMessage.getUseSSL(),true);
        try {
           MimeMessage message = getMessage(sendType,session);
            Transport transport = session.getTransport();
            transport.connect(controlMailBox.getUsername(), controlMailBox.getPassword());
            transport.sendMessage(message, message.getAllRecipients());
            resultMsg = new ResultMsg("Email Sending", true, "SUCCESS", "Send Successfully");
            transport.close();
        }catch (AddressException e){
            e.printStackTrace();
            resultMsg.setFlag("Exception");
            resultMsg.setMessage("Address is incorrect");
        }catch (MessagingException e){
            e.printStackTrace();
            resultMsg.setFlag("Exception");
            resultMsg.setMessage(e.getMessage());
        }
        return resultMsg;
    }

    private MimeMessage getMessage(SendType sendType,Session session) throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailMessage.getFrom()));
        message.setSubject(emailMessage.getSubject());
        message.setRecipients(Message.RecipientType.TO, emailMessage.getAllRicipients());
        message.addRecipient(Message.RecipientType.CC, new InternetAddress(controlMailBox.getUsername()));
        message.setSentDate(new Date());
        if(SendType.SIMPLE == sendType){
            DefaultEmailMessage defaultEmailMessage = (DefaultEmailMessage) emailMessage;
            message.setText(defaultEmailMessage.getContent(), "UTF-8");
        }
        message.saveChanges();
        return message;
    }

    public AbstractEmailMessage getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(AbstractEmailMessage emailMessage) {
        this.emailMessage = emailMessage;
    }
}
