package com.jd.mail.model;

/**
 * Created by caozhifei on 2016/5/24.
 */
public abstract class MailMessage {
    protected String[] to;
    protected String subject;

    public MailMessage(String to, String subject) {
        this.to = new String[]{to};
        this.subject = subject;
    }

    public MailMessage(String[] to, String subject) {
        this.to = to;
        this.subject = subject;
    }

    public MailMessage() {
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }
    public void setTo(String to) {
        this.to = new String[]{to};
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
