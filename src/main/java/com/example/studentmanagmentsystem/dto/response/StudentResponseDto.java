package com.example.studentmanagmentsystem.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class StudentResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private List<BookResponse> bookEntity;
    private List<CourseResponse> courseIdentity;

}
