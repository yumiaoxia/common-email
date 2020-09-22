package com.itsherman.example.template;

import com.itsherman.domain.send.AbstractEmailMessage;
import com.itsherman.domain.send.template.AbstractAssembler;
import com.itsherman.domain.send.template.AbstractMessageMeta;
import com.sun.deploy.util.StringUtils;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yumiaoxia
 * created in 2019/8/20
 * auditor: /
 * audited in /
 */
public class DemoAssembler extends AbstractAssembler {


    @Override
    public String assembleEmailMessage() throws IOException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        FileReader fileReader = new FileReader(getTemplateUrl());
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder sb = new StringBuilder();
        String lineValue = null;
        while((lineValue = bufferedReader.readLine()) != null){
            sb.append(lineValue).append("\r\n");
        }
        String template = sb.toString();
        AbstractMessageMeta messageMeta = getMessageMeta();
        BeanInfo beanInfo = Introspector.getBeanInfo(messageMeta.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String regexPattern = "\\{\\{"+ propertyDescriptor.getName() +"\\}\\}";
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(template);
            if(matcher.find()){
                String value = String.valueOf(propertyDescriptor.getReadMethod().invoke(messageMeta));
                template = matcher.replaceFirst(value);
            }
        }
        return template;
    }
}
