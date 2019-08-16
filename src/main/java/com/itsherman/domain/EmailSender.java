package com.itsherman.domain;

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

   private EmailSendInfo emailSendInfo;

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

    public ResultMsg send() {
        ResultMsg resultMsg = new ResultMsg("Email Sending",false,"exception","Unknown Exception");
        Session session = SessionFactory.openSession(emailSendInfo.getUseSSL(),true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailSendInfo.getFrom()));
            message.setText(emailSendInfo.getContent(), "UTF-8");
            message.setSubject(emailSendInfo.getSubject());
            message.setSentDate(new Date());
            message.setRecipients(Message.RecipientType.TO, emailSendInfo.getAllRicipients());
            message.addRecipient(Message.RecipientType.CC, new InternetAddress(controlMailBox.getUsername()));
            message.saveChanges();
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

    public EmailSendInfo getEmailSendInfo() {
        return emailSendInfo;
    }

    public void setEmailSendInfo(EmailSendInfo emailSendInfo) {
        this.emailSendInfo = emailSendInfo;
    }


}
