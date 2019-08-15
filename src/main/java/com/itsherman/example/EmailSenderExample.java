package com.itsherman.example;

import com.itsherman.config.ConfigManager;
import com.itsherman.config.ServerConfig;
import com.itsherman.domain.ControlMailBox;
import com.itsherman.domain.EmailSendInfo;
import com.itsherman.domain.EmailSender;
import com.itsherman.service.EmailService;
import com.itsherman.service.impl.EmailServiceImpl;

import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * <p>发送简单文本邮件实例</p>
 *
 * @author 俞淼霞
 * @since 2019-08-15
 */
public class EmailSenderExample {

    public void sendEmail() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader(MessageFormat.format("{0}/auth.properties", ServerConfig.class.getClassLoader().getResource("").getPath())));
        ControlMailBox controlMailBox = ControlMailBox.getInstance();
        controlMailBox.setUsername(prop.getProperty("username"));
        controlMailBox.setPassword(prop.getProperty("password"));


        ConfigManager manager = ConfigManager.getInstance();
        manager.setControlMailBox(controlMailBox);
        ServerConfig serverConfig = manager.getServerConfig();

        EmailSendInfo emailSendInfo = new EmailSendInfo()
                .setFrom("yumiaoxia132@163.com")
                .setSubject("java新书订购")
                .setContent("新书节盛大开幕，促销特惠，欢迎订购")
                .setUseSSL(false)
                .setToUsers("1253950375@qq.com","yumiaoxia22@163.com");
        EmailSender emailSender = new EmailSender();
        emailSender.setEmailSendInfo(emailSendInfo);
        EmailService emailService = new EmailServiceImpl();
        emailService.send(emailSender);
    }
}
