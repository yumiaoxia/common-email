package com.itsherman.service.impl;

import com.itsherman.config.ConfigManager;
import com.itsherman.config.ServerConfig;
import com.itsherman.constant.enums.SendType;
import com.itsherman.domain.send.simple.DefaultEmailMessage;
import com.itsherman.domain.send.EmailSender;
import com.itsherman.domain.ResultMsg;
import com.itsherman.domain.send.template.HtmlEmailMesage;
import com.itsherman.service.EmailService;

/**
 * <p>邮件服务</p>
 *
 * @author 俞淼霞
 * @since 2019-08-15
 */
public class EmailServiceImpl implements EmailService {

    private ConfigManager configManager;

    private EmailSender emailSender;

    public EmailServiceImpl(){
        configManager = ConfigManager.getInstance();
        emailSender = EmailSender.getInstance();
    }

    @Override
    public ResultMsg sendSimpleEmail(DefaultEmailMessage defaultEmailMessage) {
       configManager.setProtocal(ServerConfig.Protocal.SMTP);
       emailSender.setEmailMessage(defaultEmailMessage);
       return emailSender.send(SendType.SIMPLE);
    }

    @Override
    public ResultMsg sendTemplateEmail(HtmlEmailMesage htmlEmailMesage) {
        configManager.setProtocal(ServerConfig.Protocal.SMTP);
        emailSender.setEmailMessage(htmlEmailMesage);
        return emailSender.send(SendType.TEMPLATE);
    }


}
