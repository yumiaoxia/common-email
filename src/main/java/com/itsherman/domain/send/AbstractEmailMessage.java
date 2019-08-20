package com.itsherman.domain.send;

import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * @author yumiaoxia
 * created in 2019/8/20
 * auditor: /
 * audited in /
 */
public class AbstractEmailMessage {
    private String from;
    private String subject;
    private Boolean useSSL;
    private String[] toUsers;

    public String getFrom() {
        return from;
    }

    public AbstractEmailMessage setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public AbstractEmailMessage setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Boolean getUseSSL() {
        return useSSL;
    }

    public AbstractEmailMessage setUseSSL(Boolean useSSL) {
        this.useSSL = useSSL;
        return this;
    }

    public String[] getToUsers() {
        return toUsers;
    }

    public AbstractEmailMessage setToUsers(String... toUsers) {
        this.toUsers = toUsers;
        return this;
    }

    public Address[] getAllRicipients() {
        Address[] collect = new Address[toUsers.length];
        try {
            for (int i = 0; i < toUsers.length; i++) {
                collect[i] = new InternetAddress(toUsers[i]);
            }
        }catch (AddressException e){
            e.printStackTrace();
        }
        return collect;
    }


}
