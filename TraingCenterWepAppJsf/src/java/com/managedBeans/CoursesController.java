/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedBeans;

import com.exceptions.ObjectIsAleadyExist;
import com.hibernate.entities.Courses;
import com.hibernate.entities.Students;
import com.hibernate.services.CoursesService;
import com.hibernate.services.CoursesStudentsService;
import com.hibernate.services.StudentsService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author hussein
 */
@ManagedBean
@SessionScoped
public class CoursesController{

    private CoursesService service;
    private Courses course;
    private Courses addedCoursee;
    private String courseTitle;
    private Courses updatedCourse;

    // this to add new Student to course from here..
    private Students student;
    private StudentsService studentsService;
    private CoursesStudentsService coursesStudentsService;

    private Students updatedStudent;
    private Integer price;

    public Students getUpdatedStudent() {
        return updatedStudent;
    }

    public String setStudentToUpdate(Students stu) {
        this.updatedStudent = stu;
        return "updatestudent";
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String setCourse(Courses s) {
        //this.coursesStudentsController.setCourse(s);
        this.course = s;
        this.courseTitle = s.getTitle();
        this.price = course.getPrice();
        return "allstudentsincourse?faces-redirect=true";
    }

    public String setCourseToUpdate(Courses s) {
        this.updatedCourse = s;

        return "updatecourse";
    }

    public CoursesController() {
    }

    @PostConstruct
    public void init() {
        student = new Students();
        studentsService = new StudentsService();
        service = new CoursesService();
        addedCoursee = new Courses();
        coursesStudentsService = new CoursesStudentsService();
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Courses getAddedCoursee() {
        return addedCoursee;
    }

    public void setAddedCoursee(Courses addedCoursee) {
        this.addedCoursee = addedCoursee;
    }

    public List<Courses> showAllCourses() {
        return service.getAllCourses();
    }

    public Courses getCourse() {
        return course;
    }

    public void deleteCourse(Courses course) {
        service.deleteCourse(course);
    }

    public String addCourse() {
        service.addCourse(addedCoursee);
        return "dashboard?faces-redirect=true";
    }

    public List<Students> getStudentsInCourse() {
        return coursesStudentsService.getStudentsByCourse(course);
    }

    public String logOff() {
        return "index?faces-redirect=true";
    }

    public String findCourse() {
        this.course = service.findCourse(course.getId());
        return "updatecourse?faces-redirect=true";
    }

    public Courses getUpdatedCourse() {
        return updatedCourse;
    }

    public void setUpdatedCourse(Courses updatedCourse) {
        this.updatedCourse = updatedCourse;
    }

    public String updateCourse() {
        service.updateCourse(updatedCourse);
        return "dashboard?faces-redirect=true";
    }

    public String addStudent() {

        Students s = studentsService.addStudent(student);

        coursesStudentsService.addCoursesStudents(course, s);

        return "allstudentsincourse?faces-redirect=true";
    }

    public String deleteStudent(Students s) {
        studentsService.deleteStudent(s);
        return "allstudentsincourse";
    }
    
    public String updateStudent(){
        studentsService.updateStudent(updatedStudent);
        return "allstudentsincourse?faces-redirect=true";
    }
    
    public String backToCourses(){
        return "dashboard?faces-redirect=true";
    }

}
