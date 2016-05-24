package com.jd.mail.model;

import java.util.Map;

/**
 * 模版邮件信息封装类
 * Created by caozhifei on 2016/5/24.
 */
public class TemplateMailMessage extends MailMessage {
    private String templatePath;
    private Map<String,Object> model;

    public TemplateMailMessage() {
    }


    public TemplateMailMessage(String templatePath, Map<String, Object> model) {
        this.templatePath = templatePath;
        this.model = model;
    }

    public TemplateMailMessage(String to, String subject, String templatePath, Map<String, Object> model) {
        super(to, subject);
        this.templatePath = templatePath;
        this.model = model;
    }

    public TemplateMailMessage(String[] to, String subject, String templatePath, Map<String, Object> model) {
        super(to, subject);
        this.templatePath = templatePath;
        this.model = model;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
