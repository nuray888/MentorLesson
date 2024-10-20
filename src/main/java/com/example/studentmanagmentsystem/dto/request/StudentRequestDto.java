package com.example.studentmanagmentsystem.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter

public class StudentRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;

    private List<Long> booksIds;
    private List<Long> studentIds;

    public StudentRequestDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
