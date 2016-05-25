package com.jd.mail.util;

import com.jd.mail.exception.MailSentException;
import com.jd.mail.exception.TemplateMessagException;
import com.jd.mail.factory.MailFactory;
import com.jd.mail.model.TemplateMailMessage;
import com.jd.mail.model.TextMailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by caozhifei on 2016/5/24.
 */
public class MailUtil {
    private static MailFactory mailFactory;
    private static String defaultEncoding = "UTF-8";

    //初始化工厂类
    static {
        try {
            mailFactory = new MailFactory(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送简单邮件
     *
     * @param mailMessage
     * @throws MailSentException
     */
    public static void send(TextMailMessage mailMessage) throws MailSentException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailFactory.getFrom());
        message.setTo(mailMessage.getTo());
        message.setSubject(mailMessage.getSubject());
        message.setText(mailMessage.getText());
        JavaMailSender mailSender = mailFactory.getMailSender();
        mailSender.send(message);
    }

    /**
     * 发送模版邮件
     *
     * @param mailMessage
     * @throws TemplateMessagException
     */
    public static void send(TemplateMailMessage mailMessage) throws TemplateMessagException {
        JavaMailSender mailSender = mailFactory.getMailSender();
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, defaultEncoding);
        try {
            helper.setFrom(mailFactory.getFrom());
            helper.setTo(mailMessage.getTo());
            helper.setSubject(mailMessage.getSubject());
            String text = null;
            try {
                text = VelocityEngineUtils.mergeTemplateIntoString(mailFactory.getVelocityEngine(), mailMessage.getTemplatePath(), defaultEncoding, mailMessage.getModel());
            } catch (IOException e) {
                throw new TemplateMessagException(e.getMessage()+" getVelocityEngine error! ", e);
            }
            helper.setText(text, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new TemplateMessagException(e.getMessage()+" mail send error", e);
        }
    }

    /**
     * 发送模版邮件
     *
     * @param mailMessage
     * @throws TemplateMessagException
     */
    public static void send(TemplateMailMessage mailMessage, String encoding) throws TemplateMessagException {
        JavaMailSender mailSender = mailFactory.getMailSender();
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, encoding);
        try {
            helper.setFrom(mailFactory.getFrom());
            helper.setTo(mailMessage.getTo());
            helper.setSubject(mailMessage.getSubject());
            String text = null;
            try {
                text = VelocityEngineUtils.mergeTemplateIntoString(mailFactory.getVelocityEngine(), mailMessage.getTemplatePath(), encoding, mailMessage.getModel());
            } catch (IOException e) {
                throw new TemplateMessagException(e.getMessage()+" getVelocityEngine error! ", e);
            }
            helper.setText(text, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new TemplateMessagException(e.getMessage()+" mail send error", e);
        }
    }
}
