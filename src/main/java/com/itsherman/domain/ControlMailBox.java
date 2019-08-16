package com.itsherman.domain;

/**
 * @author yumiaoxia
 * created in 2019/8/16
 * auditor: /
 * audited in /
 */
public class ControlMailBox {

    private String username;

    private String password;

    private static ControlMailBox controlMailBox;


    private ControlMailBox(){
    }

    public static synchronized ControlMailBox getInstance(){
        if(controlMailBox == null ){
            synchronized (ControlMailBox.class){
                if(controlMailBox == null ){
                    controlMailBox  = new ControlMailBox();
                }
            }
        }
        return controlMailBox;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
