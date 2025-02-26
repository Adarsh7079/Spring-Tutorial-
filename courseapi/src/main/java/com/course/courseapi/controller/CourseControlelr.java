package com.course.courseapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.courseapi.entity.Course;
import com.course.courseapi.service.CourseServiceImp;

@RestController
public class CourseControlelr {

    @Autowired
    private CourseServiceImp courseService;

    @GetMapping("/home")
    public String home() {
        return "This is Page Home Page";
    }

    // Get Courses
    @GetMapping("/courses")
    //Give Error
    public ResponseEntity<List<Course>> getcourses() {
        List<Course>list=this.courseService.getcourses();;
        if (list.size()<0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    //Get Courses
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getcourses(@PathVariable String id) {
        Course course= this.courseService.getcourses(Integer.parseInt(id));
        if(course==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(course));
    }

    //Add Cousre
    @PostMapping("/courses")
    public ResponseEntity<Course> addCousre(@RequestBody Course cousre) {
        Course course=null;
        try{
          course=this.courseService.addcourse(cousre);
          return ResponseEntity.of(Optional.of(course));
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Delete Course
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("id") int id){
        try {
            this.courseService.deleteCourse(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
}
