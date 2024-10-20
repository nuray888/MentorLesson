package com.example.studentmanagmentsystem.repository;

import com.example.studentmanagmentsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {


}
