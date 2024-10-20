package com.example.studentmanagmentsystem.controller;

import com.example.studentmanagmentsystem.dto.request.BookRequest;
import com.example.studentmanagmentsystem.dto.response.BookResponse;
import com.example.studentmanagmentsystem.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/create")
    public String create(@RequestBody BookRequest bookRequest) {
        return bookService.create(bookRequest);
    }
    @GetMapping("/books/by/{id}")
    public List<BookResponse> getBooksByStudentId(@PathVariable Long id){
        return bookService.getBooksByStudentId(id);
    }



}
