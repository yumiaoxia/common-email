package com.itsherman.domain;

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
    private Boolean auth;
    private List<ToUser> toUsers;

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

    public Boolean getAuth() {
        return auth;
    }

    public EmailSendInfo setAuth(Boolean auth) {
        this.auth = auth;
        return this;
    }

    public List<ToUser> getToUsers() {
        return toUsers;
    }

    public EmailSendInfo setToUsers(List<ToUser> toUsers) {
        this.toUsers = toUsers;
        return this;
    }

    @Override
    public String toString() {
        return "EmailSendInfo{" +
                "from='" + from + '\'' +
                ", subject='" + subject + '\'' +
                ", Content='" + Content + '\'' +
                ", useSSL=" + useSSL +
                ", auth=" + auth +
                ", toUsers=" + toUsers +
                '}';
    }
}
