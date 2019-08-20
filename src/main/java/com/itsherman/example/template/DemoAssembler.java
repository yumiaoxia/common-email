package com.itsherman.example.template;

import com.itsherman.domain.send.template.AbstractAssembler;
import com.sun.java.util.jar.pack.Attribute;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * @author yumiaoxia
 * created in 2019/8/20
 * auditor: /
 * audited in /
 */
public class DemoAssembler extends AbstractAssembler {


    @Override
    public String assembleEmailMessage() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory fc = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = fc.newDocumentBuilder();
        Document document = db.parse(getTemplateUrl());
        Element root = document.getDocumentElement();
        listAll(root);
        return document.getTextContent();
    }

    private void listAll(Element element){
        NodeList childNodes = element.getChildNodes();
        if(childNodes.getLength()>1){
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node child = childNodes.item(i);
                if(child instanceof Element){
                    Element childElement = (Element)child;
                    listAll(childElement);
                }
            }
        }else{
            String idVal = element.getAttribute("id");
            Text textNode = (Text) element.getFirstChild();
            DemoMessageMeta messageMeta = (DemoMessageMeta)getMessageMeta();
            if(idVal.equals("name")){
                textNode.setData(messageMeta.getName());
            }else if(idVal.equals("message")){
                textNode.setData(messageMeta.getMessage());
            }else if(idVal.equals("time")){
                textNode.setData(messageMeta.getCreateTime());
            }

        }

    }
}
