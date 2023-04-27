package com.application.corebank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailConfig {

    @Bean
    public static JavaMailSenderImpl getMailConfig() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.auth", true);
        properties.put("mail.debug", true);


        mailSender.setHost("localhost");
        mailSender.setPort(587);
        mailSender.setUsername("corebank724@gmail.com");
        mailSender.setPassword("apttydspvcvcppze");

        return mailSender;
    }
}
