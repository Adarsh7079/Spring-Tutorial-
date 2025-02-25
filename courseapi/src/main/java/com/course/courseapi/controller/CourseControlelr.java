package com.course.courseapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.courseapi.entity.Course;
import com.course.courseapi.service.CourseService;

@RestController
public class CourseControlelr {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home(){
        return "This is Page Home Page";
    }

    //Get Courses
    @GetMapping("/courses")
    public List<Course> getcourses(){
        return this.courseService.getcourses();
    }

    //Get Courses
    @GetMapping("/courses/{id}")
    public Course getcourses(@PathVariable String id){
        return this.courseService.getcourses(Long.parseLong(id));
    }

    // Add Cousre
    @PostMapping("/courses" )
    public Course addCousre(@RequestBody Course cousre){
        return this.courseService.addcourse(cousre);
    }
}
