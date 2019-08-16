package com.itsherman.domain;

import java.io.Serializable;

/**
 * <p> </p>
 *
 * @author 俞淼霞
 * @since 2019-08-16
 */
public class ResultMsg implements Serializable {
    private String title;
private Boolean success;
private String Flag;
private String message;

    public ResultMsg() {
    }

    public ResultMsg(String title, Boolean success, String flag, String message) {
        this.title = title;
        this.success = success;
        Flag = flag;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "title='" + title + '\'' +
                ", success=" + success +
                ", Flag='" + Flag + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
