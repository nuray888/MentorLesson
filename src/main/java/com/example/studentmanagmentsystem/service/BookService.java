package com.example.studentmanagmentsystem.service;

import com.example.studentmanagmentsystem.dto.request.BookRequest;
import com.example.studentmanagmentsystem.dto.response.BookResponse;
import com.example.studentmanagmentsystem.entity.Book;
import com.example.studentmanagmentsystem.entity.Student;
import com.example.studentmanagmentsystem.repository.BookRepository;
import com.example.studentmanagmentsystem.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;

    public BookService(BookRepository bookRepository, ModelMapper modelMapper, StudentRepository studentRepository1) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.studentRepository = studentRepository1;
    }

    public String create(BookRequest bookRequest){
        Book book=modelMapper.map(bookRequest,Book.class);
//        Student student = studentRepository.findById(bookRequest.getStudentId()).orElseThrow();
//        book.setStudentEntity(student);
        bookRepository.save(book);
        return "Created";
    }
    public List<BookResponse> getBooksByStudentId(Long studentId){
        Student student = studentRepository.findById(studentId).orElseThrow();
        List<Book> books =student.getBookEntity();
        List<BookResponse> list=books.stream()
                .map(item->modelMapper.map(item,BookResponse.class))
                .toList();
        return list;
    }


}
