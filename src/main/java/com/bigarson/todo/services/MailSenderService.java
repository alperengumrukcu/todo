package com.bigarson.todo.services;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
    private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    private SimpleMailMessage message = new SimpleMailMessage();
    private Properties props = mailSender.getJavaMailProperties();

    public MailSenderService() {
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("herakliyus123@gmail.com");
        mailSender.setPassword("kfqkksdowsabnuiv");
        // ------------------------------------------------------
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
    }

    public boolean sendEmail(String to, String subject, String body) {
        try {
            message.setTo(to);
            message.setFrom("herakliyus123@gmail.com");
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}