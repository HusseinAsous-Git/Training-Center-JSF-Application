/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.services;

import com.exceptions.ObjectIsAleadyExist;
import com.hibernate.config.HibernateConnectionManager;
import com.hibernate.entities.Courses;
import com.hibernate.entities.CoursesStudents;
import com.hibernate.entities.Students;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/*
 *
 * @author hussein
 */
public class CoursesStudentsService {


    SessionFactory sessionFactory;

    public CoursesStudentsService() {
        this.sessionFactory = HibernateConnectionManager.getSessionFactory();
    }

    

    public CoursesStudents addCoursesStudents(Courses course, Students student) //throws ObjectIsAleadyExist{
        {
        
        HibernateConnectionManager.beginTransaction();
//        List<CoursesStudents> coursesStudentsList = this.getAllCorsesStudents();
        
//        for(CoursesStudents coursesStudents:coursesStudentsList){
//            if(coursesStudents.getCourses().getId().equals(course.getId()) 
//                    && coursesStudents.getStudents().getId().equals(student.getId())){
//                throw new ObjectIsAleadyExist();
//            }
//        }
        CoursesStudents cs = new CoursesStudents(course, student);
        CoursesStudents coursesStudents = (CoursesStudents) this.sessionFactory.getCurrentSession().merge(cs);
        HibernateConnectionManager.commitTransaction();
        return coursesStudents;
    }
    
    
    public CoursesStudents getCoursesStudents(int id){
        return (CoursesStudents) this.sessionFactory.getCurrentSession().get(CoursesStudents.class, id);
    }
    
    public List getAllCorsesStudents()
    {
        return this.sessionFactory.getCurrentSession().createCriteria(CoursesStudents.class).list();
    }
    
    
    public List<Students> getStudentsByCourse(Courses course){
        HibernateConnectionManager.beginTransaction();
        List<CoursesStudents> coursesStudentsList = this.getAllCorsesStudents();
        List<Students> returnedStudents = new ArrayList<Students>();
        
        for(CoursesStudents coursesStudents: coursesStudentsList){
            if(coursesStudents.getCourses().getId().equals(course.getId())){
                returnedStudents.add(coursesStudents.getStudents());
            }
        }
        HibernateConnectionManager.commitTransaction();
        return returnedStudents;
    }
}
