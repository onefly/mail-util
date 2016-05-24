package com.jd.mail.model;

/**
 * 简单信息邮件封装类
 * Created by caozhifei on 2016/5/24.
 */
public class TextMailMessage extends MailMessage{
    private String text;

    public TextMailMessage(String to, String subject, String text) {
        super(to, subject);
        this.text = text;
    }

    public TextMailMessage(String[] to, String subject, String text) {
        super(to, subject);
        this.text = text;
    }

    public TextMailMessage(String text) {
        this.text = text;
    }

    public TextMailMessage() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
