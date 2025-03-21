package com.course.courseapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {

    @Id
    // Generate automatic id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Description description;
    public void setId(long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(Description description) {
        this.description = description;
    }
    public long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Description getDescription() {
        return description;
    }
    public Course(long id, String title, Description description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public Course() {
        super();
    }

}
