/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.services;

import com.hibernate.config.HibernateConnectionManager;
import com.hibernate.config.HibernateConnectionManager;
import com.hibernate.entities.Courses;
import com.hibernate.entities.Students;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author hussein
 */
public class CoursesService {

    private SessionFactory factory;

    public CoursesService() {
        this.factory = HibernateConnectionManager.getSessionFactory();
    }

    public Courses addCourse(Courses course) {
        HibernateConnectionManager.beginTransaction();
        Courses mergerd =  (Courses) factory.getCurrentSession().merge(course);
        HibernateConnectionManager.commitTransaction();
        return mergerd;
    }
    
    public void deleteCourse(Courses course){
        HibernateConnectionManager.beginTransaction();
        factory.getCurrentSession().delete(course);
        HibernateConnectionManager.commitTransaction();
    }
    
    public Courses findCourse(int courseId){
        HibernateConnectionManager.beginTransaction();
        Courses course = (Courses) factory.getCurrentSession().get(Courses.class, courseId);
        HibernateConnectionManager.commitTransaction();
        return course;
    }
    
    public List<Courses> getAllCourses()
    {
        HibernateConnectionManager.beginTransaction();
        List l =  factory.getCurrentSession().createCriteria(Courses.class).list();
        HibernateConnectionManager.commitTransaction();
        return l;
    }
    
    public Courses updateCourse(Courses course){
        HibernateConnectionManager.beginTransaction();
         Courses c = (Courses) factory.getCurrentSession().merge(course);
         HibernateConnectionManager.commitTransaction();
         return c;
    }
    
    public Courses findCourseByName(String name)
    {
        return (Courses) factory.getCurrentSession().get(Courses.class, name);
    }

    
    

    
    
    
    
}
