package com.itsherman.session;

import com.itsherman.config.ServerConfig;
import com.itsherman.constant.PopKeyConstants;
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
        prop.put(PopKeyConstants.NO_SSL_SMTP_HOST,serverConfig.getHost());
        if(!useSSL){
            prop.put(PopKeyConstants.NO_SSL_SMTP_AUTH,String.valueOf(auth));
        }else{
            prop.put("mail.smtp.port", serverConfig.getSslPort());
            prop.put("mail.smtp.ssl.enable", "true");
            prop.put("mail,smtp.auth",true);
            prop.put(PopKeyConstants.SSL_SMTP_CLASS,SOCKETFACTORY_CLASS);
            prop.put(PopKeyConstants.SSL_SMTP_FALLBACK,"false");
            prop.put(PopKeyConstants.SSL_SMTP_PORT,serverConfig.getSslPort());
        }
        return Session.getDefaultInstance(prop);
    }
}
