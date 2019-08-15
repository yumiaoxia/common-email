package com.itsherman.service;

import com.itsherman.domain.EmailSender;


/**
 * <p>邮件服务接口</p>
 * @author 俞淼霞
 * @since 2019-08-15
 */
public interface EmailService {

    /**
     * 邮件发送
     * @param emailSender 邮件发送主体
     */
    void send(EmailSender emailSender);
}
