package com.course.courseapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.course.courseapi.entity.Course;
import java.util.List;


public interface CourseRepository extends CrudRepository<Course,Integer>{
    // Fetch course by id
    public Course findById(long id);
}
