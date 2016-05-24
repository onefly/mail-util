package com.jd.mail.exception;

import org.springframework.mail.MailException;

/**
 * Created by caozhifei on 2016/5/24.
 */
public class MailSentException extends MailException {
    public MailSentException(String msg) {
        super(msg);
    }

    public MailSentException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
