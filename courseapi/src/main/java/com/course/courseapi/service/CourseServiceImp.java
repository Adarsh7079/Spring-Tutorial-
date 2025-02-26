package com.course.courseapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.course.courseapi.dao.CourseRepository;
import com.course.courseapi.entity.Course;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseServiceImp implements CourseService{
    
    @Autowired
    private CourseRepository courseRepository;
    // List<Course> list;

    public CourseServiceImp(){
        // list=new ArrayList<>();
        // list.add(new Course(145,"Java Core Course","This is core java cousre for java Developemnt"));
        // list.add(new Course(3434,"C++ Course ","This is C++ cousre for C++ programmer"));

    }
    @Override
    public List<Course> getcourses() {
        return (List<Course>) courseRepository.findAll();
    }
    @Override
        public Course getcourses(int id) {
            Course course=null;
       try {
        course= courseRepository.findById(id);
       } catch (Exception e) {
        e.printStackTrace();
       }
       return course;
    }
    @Override
    public Course addcourse(Course course) {
        try {
            return courseRepository.save(course);
        } catch (Exception e) {
            System.out.println(e);
           throw e;
        }
    }
    @Override
    public void deleteCourse(int id) {
        Integer courseId = (int) id;  // Manual cast from long to int
        // TODO Auto-generated method stub
        Course course=courseRepository.findById(id);
        if(course==null){
            return;
        }
        courseRepository.deleteById(courseId);
    }
}
