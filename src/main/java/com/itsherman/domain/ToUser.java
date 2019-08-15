package com.itsherman.domain;

import java.io.Serializable;

/**
 * <p> </p>
 *
 * @author 俞淼霞
 * @since 2019-08-15
 */
public class ToUser implements Serializable {
    private String emailAddress;

    public ToUser() {
    }

    public ToUser(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
