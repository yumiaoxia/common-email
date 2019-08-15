package com.itsherman.config;

import com.itsherman.domain.ControlMailBox;

/**
 * @author yumiaoxia
 * created in 2019/8/16
 * auditor: /
 * audited in /
 */
public class ConfigManager {
    private static ConfigManager configManager = new ConfigManager();

    private ConfigManager(){}

    public static ConfigManager getInstance(){
        return configManager;
    }

    private ControlMailBox controlMailBox;

    private ServerConfig.Protocal protocal;

    private ServerConfig serverConfig = ServerConfig.getInstance();

    public ControlMailBox getControlMailBox() {
        return controlMailBox;
    }

    public void setControlMailBox(ControlMailBox controlMailBox) {
        this.controlMailBox = controlMailBox;
    }

    public void setProtocal(ServerConfig.Protocal protocal) {
        this.protocal = protocal;
        String username = controlMailBox.getUsername();
        if(username != null){
            if(username.contains(ServerConfig.Provider.QQ.getValue())){
                serverConfig.setProvider(ServerConfig.Provider.QQ);
            }else if(username.contains(ServerConfig.Provider.WANGYI_163.getValue())){
                serverConfig.setProvider(ServerConfig.Provider.WANGYI_163);
            }

            if(protocal!=null){
                serverConfig.setProtocal(protocal);
            }
        }
    }

    public ServerConfig getServerConfig() {

        return serverConfig;
    }


}
