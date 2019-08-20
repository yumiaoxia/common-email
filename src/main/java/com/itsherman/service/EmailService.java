package com.itsherman.service;

import com.itsherman.domain.send.simple.DefaultEmailMessage;
import com.itsherman.domain.ResultMsg;
import com.itsherman.domain.send.template.HtmlEmailMesage;


/**
 * <p>邮件服务接口</p>
 * @author 俞淼霞
 * @since 2019-08-15
 */
public interface EmailService {

    /**
     * 邮件发送
     * @param defaultEmailMessage 邮件发送主体
     */
    ResultMsg sendSimpleEmail(DefaultEmailMessage defaultEmailMessage);

    ResultMsg sendTemplateEmail(HtmlEmailMesage htmlEmailMesage);
}
