package com.example.studentmanagmentsystem.controller;

import com.example.studentmanagmentsystem.dto.response.StudentResponseDto;
import com.example.studentmanagmentsystem.dto.request.StudentRequestDto;
import com.example.studentmanagmentsystem.entity.Student;
import com.example.studentmanagmentsystem.repository.StudentRepository;
import com.example.studentmanagmentsystem.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;
    private final StudentRepository studentRepository;


    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/get-all")
    public List<StudentResponseDto> getAllController() {
        return studentService.getAll();
    }

    @PostMapping("/create")
    public String create(@RequestBody StudentRequestDto studentDto) {
        return studentService.create(studentDto);
    }

    @GetMapping("/find-by-id")
    public StudentResponseDto findById(@RequestParam Long id){
        StudentResponseDto responseDto = studentService.findByID(id);
        return responseDto;
    }


    @DeleteMapping("/delete{id}")
    public String deleteControllerById(@PathVariable Long id) {
        return studentService.delete(id);

    }

    @PutMapping("/update")
    public StudentResponseDto updateController(@RequestParam Long id, @RequestBody StudentRequestDto studentDto) {
        StudentResponseDto update = studentService.update(id, studentDto);
        return update;
    }

    @GetMapping("/searchByLastName")
    public List<Student> searchByLastName(@RequestParam String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    @GetMapping("/find-date-before")
    public List<Student> findByDateOfBirthBefore(@RequestParam LocalDate date) {
        return studentRepository.findByDateOfBirthBefore(date);
    }
    @GetMapping("/find-by-email")
    public List<Student> findByEmailContaining(@RequestParam String email){
        return studentRepository.findByEmailContaining(email);
    }




}
