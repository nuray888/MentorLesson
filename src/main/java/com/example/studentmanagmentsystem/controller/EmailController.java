package com.example.studentmanagmentsystem.controller;

//import com.example.studentmanagmentsystem.dto.request.EmailRequest;
import com.example.studentmanagmentsystem.dto.request.EmailRequest;
import com.example.studentmanagmentsystem.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import org.hibernate.annotations.Parameter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

import java.awt.*;
import java.io.IOException;


@RestController
@RequestMapping("/mail")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }


    @PostMapping("/simple")
    public String sendEmail() {
        return emailService.sendEmail();
    }

    @PostMapping(value = "/send/with/attachment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String sendMultiPart(

            @RequestPart("to") String to,
                                      @RequestPart("subject") String subject,
                                      @RequestPart("text") String text,
                                      @RequestPart(value = "files",required = true)
                                MultipartFile file) throws MessagingException, IOException {
        return emailService.sendEmailWithAttachment( file, to, subject, text);

    }


}
