package com.example.studentmanagmentsystem.controller;

import com.example.studentmanagmentsystem.dto.request.CourseRequest;
import com.example.studentmanagmentsystem.dto.response.CourseResponse;
import com.example.studentmanagmentsystem.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public void createController(@RequestBody CourseRequest courseRequest){
        service.create(courseRequest);
    }
    @GetMapping("/get-all")
    public List<CourseResponse> getAllController(){
       return  service.getAllCourses();
    }
    @GetMapping
    public CourseResponse getByIdController(@PathVariable Long id){
        return service.getById(id);
    }


}
