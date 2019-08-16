package com.itsherman.service.impl;

import com.itsherman.config.ConfigManager;
import com.itsherman.config.ServerConfig;
import com.itsherman.domain.EmailSendInfo;
import com.itsherman.domain.EmailSender;
import com.itsherman.domain.ResultMsg;
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
    public ResultMsg send(EmailSendInfo emailSendInfo) {
       configManager.setProtocal(ServerConfig.Protocal.SMTP);
       emailSender.setEmailSendInfo(emailSendInfo);
       return emailSender.send();
    }


}
