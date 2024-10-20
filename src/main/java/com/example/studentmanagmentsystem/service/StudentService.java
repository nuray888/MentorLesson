package com.example.studentmanagmentsystem.service;

import com.example.studentmanagmentsystem.dto.response.StudentResponseDto;
import com.example.studentmanagmentsystem.dto.request.StudentRequestDto;
import com.example.studentmanagmentsystem.entity.Book;
import com.example.studentmanagmentsystem.entity.Course;
import com.example.studentmanagmentsystem.entity.Student;
import com.example.studentmanagmentsystem.repository.BookRepository;
import com.example.studentmanagmentsystem.repository.CourseRepository;
import com.example.studentmanagmentsystem.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final BookRepository bookRepository;
    private final CourseRepository courseRepository;


    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper, BookRepository bookRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
        this.courseRepository = courseRepository;
    }

    public List<StudentResponseDto> getAll(){
        List<Student> all=studentRepository.findAll();
        List<StudentResponseDto> list = all.stream()
                .map(s -> modelMapper.map(s, StudentResponseDto.class))
                .toList();
        return list;
    }

    public String create(StudentRequestDto studentDto){
        Student student = modelMapper.map(studentDto, Student.class);

        List<Book> books =new ArrayList<>();

        List<Long> booksIds = studentDto.getBooksIds();  // 1 , 8 , 9 , 15

        for (Long item : booksIds){
            Book book = bookRepository.findById(item).orElseThrow();
            books.add(book);
        }

        List<Course> allById = courseRepository.findAllById(studentDto.getStudentIds());
        student.setCourseIdentity(allById);


        student.setBookEntity(books);

        studentRepository.save(student);
        return "Sucsessful";
    }

    //find by Id
    public StudentResponseDto findByID(Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        return modelMapper.map(student, StudentResponseDto.class);
    }

    public StudentResponseDto update(Long id, StudentRequestDto studentRequestDTO)  {
        Student student = studentRepository.findById(id).orElseThrow();
            modelMapper.map(studentRequestDTO, student);
            Student updatedStudent = studentRepository.save(student);
            return modelMapper.map(updatedStudent, StudentResponseDto.class);
        }




    public String delete(Long id){
        Student student = studentRepository.findById(id).orElseThrow();
        studentRepository.delete(student);
        return "Sucsessfully deleted";
    }
}
