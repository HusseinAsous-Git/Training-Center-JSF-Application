/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedBeans;

import com.hibernate.entities.Students;
import com.hibernate.services.CoursesStudentsService;
import com.hibernate.services.StudentsService;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hussein
 */
@ManagedBean
@SessionScoped
public class StudentsController{

    private Students student;
    private StudentsService studentService;
    private CoursesStudentsService coursesStudentsService;
    
    
    public StudentsController() {
    }

    

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }
    
    
   

    
    
    
}
