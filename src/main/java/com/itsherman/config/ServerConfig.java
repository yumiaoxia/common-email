package com.itsherman.config;

import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * <p>邮件服务提供商服务器配置</p>
 *
 * @author 俞淼霞
 * @since 2019-08-15
 */
public class ServerConfig {

    private static ServerConfig serverConfig = new ServerConfig();
    private static Properties prop = new Properties();
    private static String HOST = "email.%s.%s.host";
    private static String PORT = "email.%s.%s.port";
    private static String SSL_PORT = "email.%s.%s.ssl.port";

    static {
        try {
            prop.load(new FileReader(MessageFormat.format("{0}/mailserver.properties", ServerConfig.class.getClassLoader().getResource("").getPath())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ServerConfig(){}

    public static ServerConfig getInstance(){
        return serverConfig;
    }

    private Provider provider;

    private Protocal protocal;

    private String host = HOST;

    private String port = PORT;

    private String sslPort = SSL_PORT;

    public String getHost() {
       String hostKey =  String.format(HOST,provider.getValue(),protocal.getValue());
       return prop.getProperty(hostKey);
    }

    public String getPort() {
        String portKey =  String.format(PORT,provider.getValue(),protocal.getValue());
        return  prop.getProperty(portKey);
    }

    public String getSslPort() {
        String sslPortKey =  String.format(SSL_PORT,provider.getValue(),protocal.getValue());
        return prop.getProperty(sslPortKey);
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public void setProtocal(Protocal protocal) {
        this.protocal = protocal;
    }

    static  enum Provider{
        QQ("qq"),
        WANGYI_163("163");

        private final String value;

        Provider(String value) {
            this.value  = value;
        }

        public String getValue() {
            return value;
        }
    }

   public static enum Protocal{
        SMTP("smtp"),POP3("pop"),IMAP("imap");
        private final String value;

        Protocal(String value) {
            this.value  = value;
        }

        public String getValue() {
            return value;
        }
    }
}
