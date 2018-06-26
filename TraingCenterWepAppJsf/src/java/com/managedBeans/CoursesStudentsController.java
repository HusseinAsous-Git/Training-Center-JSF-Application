/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedBeans;

import com.hibernate.entities.Courses;
import com.hibernate.entities.Students;
import com.hibernate.services.CoursesStudentsService;
import com.hibernate.services.StudentsService;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hussein
 */
@ManagedBean
@SessionScoped
public class CoursesStudentsController{

    

    private Courses course;
    private CoursesStudentsService coursesStudentsService;
    private StudentsService studentsService;
   
   
    
    
    public CoursesStudentsController() {
    }
    
    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

   
    
    @PostConstruct
    public void init(){
        coursesStudentsService = new CoursesStudentsService();
        studentsService = new StudentsService();
     
    }
    
    
    public List<Students> getStudentsInCourse(){
        return coursesStudentsService.getStudentsByCourse(course);
    }
    
    
  
    
    
}
