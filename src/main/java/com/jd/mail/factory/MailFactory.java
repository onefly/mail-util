package com.jd.mail.factory;

import com.jd.mail.util.ConfigUtil;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by caozhifei on 2016/5/24.
 */
public class MailFactory {
    private Properties PROP;
    private JavaMailSender mailSender;
    private VelocityEngine velocityEngine;
    //发件人邮箱
    private String from;

    public MailFactory(String propertiesPath) throws IOException {
        if(propertiesPath == null || propertiesPath.length() ==0){
            propertiesPath =  "important.properties";
        }
        PROP = ConfigUtil.getPropertiesFile(propertiesPath);
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(PROP.getProperty("mail.host"));
        mailSender.setPort(Integer.valueOf(PROP.getProperty("mail.port")));
        mailSender.setUsername(PROP.getProperty("mail.username"));
        mailSender.setPassword(PROP.getProperty("mail.password"));
        this.from = PROP.getProperty("mail.from");
        this.mailSender = mailSender;
    }

    public JavaMailSender getMailSender() {
        return this.mailSender;
    }

    public VelocityEngine getVelocityEngine() throws IOException {
        if (this.velocityEngine != null) {
            return this.velocityEngine;
        }
        synchronized (this) {
            VelocityEngineFactoryBean factoryBean = new VelocityEngineFactoryBean();
            Map<String, Object> velocityPropertiesMap = new HashMap<String, Object>();
            velocityPropertiesMap.put("resource.loader", "class");
            velocityPropertiesMap.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            factoryBean.setVelocityPropertiesMap(velocityPropertiesMap);
            this.velocityEngine = factoryBean.createVelocityEngine();
        }
        return this.velocityEngine;
    }

    public String getFrom() {
        return from;
    }
}
