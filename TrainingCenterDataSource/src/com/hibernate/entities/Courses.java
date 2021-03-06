package com.hibernate.entities;
// Generated Oct 24, 2017 3:37:38 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Courses generated by hbm2java
 */
public class Courses  implements java.io.Serializable {


     private Integer id;
     private String title;
     private Integer price;
     private Set coursesStudentses = new HashSet(0);

    public Courses() {
    }

	
    public Courses(String title, Integer price) {
        this.title = title;
        this.price = price;
    }
    public Courses(String title, Integer price, Set coursesStudentses) {
       this.title = title;
       this.price = price;
       this.coursesStudentses = coursesStudentses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getPrice() {
        return this.price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Set getCoursesStudentses() {
        return this.coursesStudentses;
    }
    
    public void setCoursesStudentses(Set coursesStudentses) {
        this.coursesStudentses = coursesStudentses;
    }




}


