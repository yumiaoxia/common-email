package com.itsherman.service.impl;

import com.itsherman.domain.EmailSender;
import com.itsherman.service.EmailService;

/**
 * <p>邮件服务</p>
 *
 * @author 俞淼霞
 * @since 2019-08-15
 */
public class EmailServiceImpl implements EmailService {

    @Override
    public void send(EmailSender emailSender) {
        emailSender.send();
    }


}
