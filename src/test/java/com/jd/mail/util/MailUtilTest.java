package com.jd.mail.util;

import com.jd.mail.model.TemplateMailMessage;
import com.jd.mail.model.TextMailMessage;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MailUtilTest {

    @Test
    public void testSend() throws Exception {
        TextMailMessage message = new TextMailMessage();
        message.setTo("529352479@qq.com");
        message.setSubject("测试邮件工具类");
        message.setText("这里是邮件发送工具类的正文内容");
        MailUtil.send(message);
    }

    @Test
    public void testSend1() throws Exception {
        TemplateMailMessage message = new TemplateMailMessage();
        message.setTo("529352479@qq.com");
        message.setSubject("测试邮件工具类618");
        Map model = new HashMap();
        model.put("user", "京东618");
        model.put("text","这里是通过模版吐出的内容 !");
        message.setModel(model);
        message.setTemplatePath("template/demo.vm");
        MailUtil.send(message);
    }

    @Test
    public void testSend2() throws Exception {
        TemplateMailMessage message = new TemplateMailMessage();
        message.setTo("529352479@qq.com");
        message.setSubject("测试邮件工具类2");
        Map model = new HashMap();
        model.put("user", "京东");
        model.put("text","这里是通过模版吐出的内容 !");
        message.setModel(model);
        message.setTemplatePath("template/demo.vm");
        MailUtil.send(message,"UTF-8");
    }
}