package com.example.studentmanagmentsystem.dto.response;

import com.example.studentmanagmentsystem.entity.Student;
import lombok.Data;

import java.time.LocalDate;
@Data
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private LocalDate publishedDate;
//    private Student studentEntity;
}
