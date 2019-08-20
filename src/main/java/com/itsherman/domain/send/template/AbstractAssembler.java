package com.itsherman.domain.send.template;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author yumiaoxia
 * created in 2019/8/20
 * auditor: /
 * audited in /
 */
public abstract class AbstractAssembler {

    private String templateUrl;

    private AbstractMessageMeta messageMeta;


    public abstract String assembleEmailMessage() throws ParserConfigurationException, IOException, SAXException;

    public String getTemplateUrl() {
        return templateUrl;
    }

    public void setTemplateUrl(String templateUrl) {
        this.templateUrl = templateUrl;
    }

    public AbstractMessageMeta getMessageMeta() {
        return messageMeta;
    }

    public void setMessageMeta(AbstractMessageMeta messageMeta) {
        this.messageMeta = messageMeta;
    }
}
