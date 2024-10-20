package com.example.studentmanagmentsystem.service;

//import com.example.studentmanagmentsystem.dto.request.EmailRequest;
import com.example.studentmanagmentsystem.dto.request.AddressRequest;
import com.example.studentmanagmentsystem.dto.request.EmailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class EmailService {

    @Value("${mail}")
    private String from;
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

//    @Scheduled(fixedRate = 100000)
//@Scheduled(cron = "0 09 16 * * ?")
    public String sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("nuraymuxtarli67@gmail.com");
        msg.setFrom(from);
        msg.setSubject("java");
        msg.setText("java");
        javaMailSender.send(msg);
        return "Successful";
    }


    public String sendEmailWithAttachment(MultipartFile multipartFile, String to, String subject, String text) throws MessagingException, IOException {
        MimeMessage msg = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
//        helper.setTo("nuraymuxtarli67@gmail.com");
//        helper.setFrom(from);
//        helper.setSubject("java");
//        helper.setText("java");

        helper.setTo(to);
        helper.setFrom(from);
        helper.setSubject(subject);
        helper.setText(text);

        String originalFileName = multipartFile.getOriginalFilename();
        helper.addAttachment(originalFileName, multipartFile);
        javaMailSender.send(msg);
        return "Sucsesfull";
    }


}
