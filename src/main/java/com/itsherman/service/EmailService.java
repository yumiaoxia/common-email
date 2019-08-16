package com.itsherman.service;

import com.itsherman.domain.EmailSendInfo;
import com.itsherman.domain.EmailSender;
import com.itsherman.domain.ResultMsg;


/**
 * <p>邮件服务接口</p>
 * @author 俞淼霞
 * @since 2019-08-15
 */
public interface EmailService {

    /**
     * 邮件发送
     * @param emailSendInfo 邮件发送主体
     */
    ResultMsg send(EmailSendInfo emailSendInfo);
}
