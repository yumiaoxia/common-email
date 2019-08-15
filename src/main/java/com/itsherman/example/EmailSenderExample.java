package com.itsherman.example;

import com.itsherman.config.ServerConfig;
import com.itsherman.domain.EmailSendInfo;
import com.itsherman.domain.EmailSender;
import com.itsherman.domain.ToUser;
import com.itsherman.service.EmailService;
import com.itsherman.service.impl.EmailServiceImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * <p>发送简单文本邮件实例</p>
 *
 * @author 俞淼霞
 * @since 2019-08-15
 */
public class EmailSenderExample {

    public void sendEmial() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader(System.getProperty("user.dir")+"/src/main/resources/mailserver.properties"));
        int size = prop.size();
        ServerConfig serverConfig =ServerConfig.getInstance();
        serverConfig.setHost(prop.getProperty("email.163.smtp.host"));
        serverConfig.setPort(prop.getProperty("email.163.smtp.port"));
        serverConfig.setSslPort(prop.getProperty("email.163.smtp.ssl.port"));
        List<ToUser> toUsers = new ArrayList<>();
        toUsers.add(new ToUser("yumiaoxia22@163.com"));
        EmailSendInfo emailSendInfo = new EmailSendInfo()
                .setAuth(false)
                .setFrom("yumiaoxia132@163.com")
                .setSubject("上课通知")
                .setContent("理单待客审开关。可取值：1/0 ；格式：review_{渠道类型}_{门店号}_{订单类型}；不设置时 1 为默认值。")
                .setUseSSL(false)
                .setToUsers(toUsers);
        EmailSender emailSender = new EmailSender();
        emailSender.setEmailSendInfo(emailSendInfo);
        EmailService emailService = new EmailServiceImpl();
        emailService.send(emailSender);
    }
}
