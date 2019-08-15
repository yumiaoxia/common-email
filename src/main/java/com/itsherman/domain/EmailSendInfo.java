package com.itsherman.domain;

import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p> </p>
 *
 * @author 俞淼霞
 * @since 2019-08-15
 */
public class EmailSendInfo {
    private String from;
    private String subject;
    private String Content;
    private Boolean useSSL;
    private List<String> toUsers;

    public String getFrom() {
        return from;
    }

    public EmailSendInfo setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public EmailSendInfo setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getContent() {
        return Content;
    }

    public EmailSendInfo setContent(String content) {
        Content = content;
        return this;
    }

    public Boolean getUseSSL() {
        return useSSL;
    }

    public EmailSendInfo setUseSSL(Boolean useSSL) {
        this.useSSL = useSSL;
        return this;
    }

    public List<Address> getAllRicipients() {
        List<Address> collect = null ;
        try {
             collect = new ArrayList<>();
            for (String address : this.toUsers) {
                InternetAddress internetAddress = new InternetAddress(address);
                collect.add(internetAddress);
            }

        }catch (AddressException e){
            e.printStackTrace();
        }
        return collect;
    }

    public EmailSendInfo setToUsers(String... destAddress) {
        this.toUsers = Arrays.asList(destAddress);
        return this;
    }

}
