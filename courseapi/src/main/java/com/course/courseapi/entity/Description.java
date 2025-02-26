package com.course.courseapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Description {
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private int course_id;

    private float course_price;
    private String overview;

    @OneToOne(mappedBy = "description")
    @JsonBackReference
    private Course course;
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public Description() {
    }
    public Description( float course_price, String overview,int course_id) {
        this.course_id=course_id;
        this.course_price = course_price;
        this.overview = overview;
    }
    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
    public float getcourse_price() {
        return course_price;
    }
    public void setcourse_price(float course_price) {
        this.course_price = course_price;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
}
