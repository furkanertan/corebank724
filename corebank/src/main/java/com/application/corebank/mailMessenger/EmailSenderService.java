package com.application.corebank.mailMessenger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Slf4j
@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender sender;

    public void htmlEmailMessenger(String from, String toMail, String subject, String body) throws MessagingException {
        //mime message
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        //set message
        helper.setFrom(from);
        helper.setTo(toMail);
        helper.setSubject(subject);
        helper.setText(body, true);

        log.info("Sending email from: " + from);
        log.info("Sending email to: " + toMail);
        log.info("Email subject: " + subject);
        log.info("Email body: " + body);

        sender.send(message);
    }
}
