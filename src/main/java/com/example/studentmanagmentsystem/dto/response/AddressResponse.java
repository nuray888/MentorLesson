package com.example.studentmanagmentsystem.dto.response;

import com.example.studentmanagmentsystem.entity.Student;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class AddressResponse {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private Student studentEntity;
}
