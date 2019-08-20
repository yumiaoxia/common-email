package com.itsherman.domain.send.template;

import com.itsherman.domain.send.AbstractEmailMessage;
import com.itsherman.example.template.DemoAssembler;

/**
 * @author yumiaoxia
 * created in 2019/8/20
 * auditor: /
 * audited in /
 */
public class HtmlEmailMesage extends AbstractEmailMessage {

    private String templateUrl;

    private AbstractMessageMeta messageMeta;

    private AbstractAssembler abstractAssembler;

    public String getContent(){
        abstractAssembler.setMessageMeta(messageMeta);
        abstractAssembler.setTemplateUrl(templateUrl);
        String content = null;
        try {
            content = abstractAssembler.assembleEmailMessage();
        }catch (Exception e){
            e.printStackTrace();
        }
        return content;
    }

    public HtmlEmailMesage setTemplateUrl(String templateUrl) {
        this.templateUrl = templateUrl;
        return this;
    }

    public HtmlEmailMesage setMessageMeta(AbstractMessageMeta messageMeta) {
        this.messageMeta = messageMeta;
        return this;
    }

    public HtmlEmailMesage setAbstractAssembler(AbstractAssembler abstractAssembler) {
        this.abstractAssembler = abstractAssembler;
        return this;
    }
}
