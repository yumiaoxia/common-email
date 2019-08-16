package com.itsherman.session;

import com.itsherman.config.ServerConfig;
import com.itsherman.constant.PopKeyConstants;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * <p> </p>
 *
 * @author 俞淼霞
 * @since 2019-08-15
 */
public class SessionFactory {
    private static final String SMTP_PROTOCAL = "smtp";
    private static final String SOCKETFACTORY_CLASS = "javax.net.ssl.SSLSocketFactory";

    public static Session openSession(boolean useSSL,boolean auth){
        ServerConfig serverConfig = ServerConfig.getInstance();
        Properties prop = new Properties();
        prop.setProperty(PopKeyConstants.TRANSPORT_PROTOCAL,SMTP_PROTOCAL);
        if(!useSSL){
            prop.put(PopKeyConstants.NO_SSL_SMTP_HOST,serverConfig.getHost());
            prop.put(PopKeyConstants.NO_SSL_SMTP_AUTH,String.valueOf(auth));
        }else{
            prop.put(PopKeyConstants.SMTP_PORT,serverConfig.getPort());
            prop.put(PopKeyConstants.SSL_SMTP_CLASS,SOCKETFACTORY_CLASS);
            prop.put(PopKeyConstants.SSL_SMTP_FALLBACK,"false");
            prop.put(PopKeyConstants.SSL_SMTP_PORT,serverConfig.getPort());
        }
        return Session.getDefaultInstance(prop);
    }
}
