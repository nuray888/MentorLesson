package com.example.studentmanagmentsystem.dto.request;

import jakarta.validation.constraints.Email;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {

    @Email(message = "invalid email format")
    private String to;

    private String subject;
    private String text;
}
