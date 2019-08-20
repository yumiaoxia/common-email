package com.itsherman.example.template;

import com.itsherman.domain.send.template.AbstractMessageMeta;

import java.time.LocalDateTime;

/**
 * @author yumiaoxia
 * created in 2019/8/20
 * auditor: /
 * audited in /
 */
public class DemoMessageMeta extends AbstractMessageMeta {

    private String name;

    private String message;

    private String createTime;

    public DemoMessageMeta(String name, String message, String createTime) {
        this.name = name;
        this.message = message;
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
