
import com.hibernate.entities.Courses;
import com.hibernate.entities.Students;
import com.hibernate.services.CoursesService;
import com.hibernate.services.StudentsService;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hussein
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        try {
            com.hibernate.config.HibernateConnectionManager.setConfigFile("hibernate.cfg.xml");
            
            
          
            
            StudentsService studentsService = new StudentsService();
//            Students student = studentsService.findStudent(1);
//            
//            System.out.println("First-Name:" +student.getFirstName());
//            System.out.println("Last-Name:" +student.getLastName());
//            System.out.println("Faculty:" +student.getFaculty());
//            System.out.println("Gender:" +student.getGender());
//            System.out.println("Phone:" +student.getPhone());
//            System.out.println("Address:" +student.getAddress());
//            System.out.println("Paid:" +student.getPaid());


            CoursesService coursesService = new CoursesService();
            List<Courses> allCourses = coursesService.getAllCourses();
            for(Courses c : allCourses){
                System.out.println("Name:" + c.getTitle());
            }
//            List<Courses> courses = coursesService.getAllCourses();
//            for(Courses course: courses){
//                System.out.println("Id: "+course.getId());
//                System.out.println("Tilte: "+course.getTitle());
//                System.out.println("Price: "+course.getPrice());
//            }
            





            
          
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
