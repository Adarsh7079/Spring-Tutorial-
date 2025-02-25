package com.course.courseapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.course.courseapi.entity.Course;

@Service
public class CourseServiceImp implements CourseService{
    
    List<Course> list;

    public CourseServiceImp(){
        list=new ArrayList<>();
        list.add(new Course(145,"Java Core Course","This is core java cousre for java Developemnt"));
        list.add(new Course(3434,"C++ Course ","This is C++ cousre for C++ programmer"));

    }
    @Override
    public List<Course> getcourses() {
        return list;
    }
    @Override
    public Course getcourses(long id) {
        Course c=null;

        for(Course cousre:list){
            if(cousre.getId()==id){
                c=cousre;
                break;
            }
        }
        return c;
    }
    @Override
    public Course addcourse(Course course) {
        list.add(course);
        return null;
    }
}
