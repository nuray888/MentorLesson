package com.example.studentmanagmentsystem.service;

import com.example.studentmanagmentsystem.dto.request.CourseRequest;
import com.example.studentmanagmentsystem.dto.response.CourseResponse;
import com.example.studentmanagmentsystem.entity.Course;
import com.example.studentmanagmentsystem.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public CourseService(CourseRepository courseRepository, ModelMapper modelMapper) {
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    public String create(CourseRequest courseRequest){
        Course course=modelMapper.map(courseRequest,Course.class);
        courseRepository.save(course);
        return "Created";
    }

    public List<CourseResponse> getAllCourses(){
        List<Course> all = courseRepository.findAll();
        List<CourseResponse> list = all.stream().map(item -> modelMapper.map(item, CourseResponse.class)).toList();
        return list ;

    }
    public CourseResponse getById(Long id){
        Course course = courseRepository.findById(id).orElseThrow();
        CourseResponse map = modelMapper.map(course, CourseResponse.class);
        return map;
    }

}
