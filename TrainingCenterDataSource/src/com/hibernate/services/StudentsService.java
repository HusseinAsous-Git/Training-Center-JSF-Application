/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.services;

import com.hibernate.config.HibernateConnectionManager;
import com.hibernate.config.HibernateConnectionManager;
import com.hibernate.entities.Students;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author hussein
 */
public class StudentsService {

    private SessionFactory factory;

    public StudentsService() {
        this.factory = HibernateConnectionManager.getSessionFactory();
    }

    public Students addStudent(Students student) {
        HibernateConnectionManager.beginTransaction();
        Students s = (Students) factory.getCurrentSession().merge(student);
        HibernateConnectionManager.commitTransaction();
        return s;
    }

    public void deleteStudent(Students student) {
        HibernateConnectionManager.beginTransaction();
        factory.getCurrentSession().delete(student);
        HibernateConnectionManager.commitTransaction();
    }

    public Students findStudent(int studentId) {
        return (Students) factory.getCurrentSession().get(Students.class, studentId);
    }

    public List<Students> getAllStudents() {
        return factory.getCurrentSession().createCriteria(Students.class).list();
    }

    public Students updateStudent(Students student) {
        HibernateConnectionManager.beginTransaction();
        Students s = (Students) factory.getCurrentSession().merge(student);
        HibernateConnectionManager.commitTransaction();
        return s;
    }

    public Students findStudentByName(String name) {
        return (Students) factory.getCurrentSession().get(Students.class, name);
    }

}
