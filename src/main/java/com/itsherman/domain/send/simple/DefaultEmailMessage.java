package com.itsherman.domain.send.simple;

import com.itsherman.domain.send.AbstractEmailMessage;

/**
 * <p> </p>
 *
 * @author 俞淼霞
 * @since 2019-08-15
 */
public class DefaultEmailMessage extends AbstractEmailMessage {
    private String content;

    public DefaultEmailMessage() {
        super();
    }

    public String getContent() {
        return content;
    }

    public DefaultEmailMessage setContent(String content) {
        this.content = content;
        return this;
    }
}
