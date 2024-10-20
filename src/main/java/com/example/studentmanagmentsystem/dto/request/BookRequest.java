package com.example.studentmanagmentsystem.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BookRequest {
    private String title;
    private String author;
    private LocalDate publishedDate;
//    private Long studentId;
}
