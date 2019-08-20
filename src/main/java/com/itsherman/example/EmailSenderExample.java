package com.itsherman.example;

import com.itsherman.config.ConfigManager;
import com.itsherman.config.ServerConfig;
import com.itsherman.domain.ControlMailBox;
import com.itsherman.domain.EmailSendInfo;
import com.itsherman.domain.EmailSender;
import com.itsherman.domain.ResultMsg;
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

    private EmailService emailService;

    public EmailSenderExample(){
        Properties prop = new Properties();
        try {
            prop.load(new FileReader(MessageFormat.format("{0}/auth.properties", ServerConfig.class.getClassLoader().getResource("").getPath())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ControlMailBox controlMailBox = ControlMailBox.getInstance();
        controlMailBox.setUsername(prop.getProperty("account"));
        controlMailBox.setPassword(prop.getProperty("password"));

        ConfigManager manager = ConfigManager.getInstance();
        manager.setControlMailBox(controlMailBox);

        emailService = new EmailServiceImpl();
    }

    public void sendEmail() {
        EmailSendInfo emailSendInfo = new EmailSendInfo()
                .setFrom("yumiaoxia132@163.com")
                .setSubject("课程信息")
                .setContent("各位同学们，从本月8月19日开始报名学费从6199元上调为6899\n" +
                        "实际报名学费最低不能低于5000！！！\n" +
                        "现在报名学费6199元还可以优惠1500\n" +
                        "实际只需要4699！！！\n" +
                        "还能享受终生免费学习啦！！！\n")
                .setUseSSL(true)
                .setToUsers("1253950375@qq.com","yumiaoxia22@163.com");
        ResultMsg resultMsg = emailService.send(emailSendInfo);
        System.out.println(resultMsg);
    }
}
