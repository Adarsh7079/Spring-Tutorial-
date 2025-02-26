package com.course.courseapi.service;

import java.util.List;

import com.course.courseapi.entity.Course;

public interface CourseService {
    public List<Course> getcourses();
    public Course getcourses(int id);
    public Course addcourse(Course course);
    public void deleteCourse(int id);

}
