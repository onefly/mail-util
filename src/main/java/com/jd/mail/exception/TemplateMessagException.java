package com.jd.mail.exception;

import javax.mail.MessagingException;

/**
 * Created by caozhifei on 2016/5/24.
 */
public class TemplateMessagException extends MessagingException {
    public TemplateMessagException() {
    }

    public TemplateMessagException(String s) {
        super(s);
    }

    public TemplateMessagException(String s, Exception e) {
        super(s, e);
    }
}
