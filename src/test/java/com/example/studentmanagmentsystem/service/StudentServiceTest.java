package com.example.studentmanagmentsystem.service;

import com.example.studentmanagmentsystem.dto.request.StudentRequestDto;
import com.example.studentmanagmentsystem.dto.response.StudentResponseDto;
import com.example.studentmanagmentsystem.entity.Student;
import com.example.studentmanagmentsystem.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @InjectMocks
    StudentService studentService;

    @Mock
    StudentRepository studentRepository;

    @Mock
    ModelMapper modelMapper;


    @Test
    public void testStudentService() {
        Student student = new Student(1L, "Nuray", "muxtarli");
        Student student1 = new Student(2L, "Gunel", "Quliyeva");

        List<Student> all = List.of(student, student1);

        when(studentRepository.findAll()).thenReturn(all);

        List<StudentResponseDto> list = all.stream()
                .map(s -> modelMapper.map(s, StudentResponseDto.class))
                .toList();

        List<StudentResponseDto> actual = studentService.getAll();

        Assertions.assertEquals(list, actual);
    }

    @Test
    public void findByIdTest() {
        Student student = new Student(1L, "Nuray", "Muxtarli");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        StudentResponseDto map = modelMapper.map(student, StudentResponseDto.class);

        StudentResponseDto actual = studentService.findByID(1L);

        Assertions.assertEquals(map, actual);


    }

    @Test
    public void deleteTest() {
        Student student = new Student(1L, "Nuray", "Muxtarli");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        String delete = studentService.delete(1L);
        Assertions.assertEquals("Sucsessfully deleted", delete);
    }

    @Test
    public void updateTest() {
        StudentRequestDto studentRequestDTO = new StudentRequestDto("Nuray", "Muxtarli");
        Student student = new Student(1L, "Nuray", "Muxtarli");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        modelMapper.map(studentRequestDTO, student);
        when(studentRepository.save(student)).thenReturn(student);

        StudentResponseDto map = modelMapper.map(student, StudentResponseDto.class);

        StudentResponseDto actual = studentService.update(1L, studentRequestDTO);

        Assertions.assertEquals(map, actual);


    }



}
