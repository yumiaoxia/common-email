package com.itsherman.config;

import com.sun.security.ntlm.Server;

/**
 * <p>邮件服务提供商服务器配置</p>
 *
 * @author 俞淼霞
 * @since 2019-08-15
 */
public class ServerConfig {

    private static ServerConfig serverConfig = new ServerConfig();
    private ServerConfig(){

    }
    public static ServerConfig getInstance(){
        return serverConfig;
    }

    private String host;

    private String port;

    private String sslPort;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSslPort() {
        return sslPort;
    }

    public void setSslPort(String sslPort) {
        this.sslPort = sslPort;
    }

    @Override
    public String toString() {
        return "ServerConfig{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", sslPort='" + sslPort + '\'' +
                '}';
    }
}
