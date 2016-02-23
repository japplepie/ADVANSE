
import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */
public class EnrollmentSystem {
    
    ArrayList<Course> courses;
    
    public EnrollmentSystem()
    {
        courses = new ArrayList<>();
    }
    
    public void register(Student student){}
    
    public boolean checkLogin(String id, String password)
    {
        //placeholder
        return true;
    }
    
    public void openLogin(boolean open)
    {
        
    }
    
    public void openRegister(boolean open)
    {
        
    }
    
    public void openViewCourses(boolean open)
    {
        
    }
    
    public Iterator<String> getCourses()
    {
        ArrayList<String> courseCodes = new ArrayList<>();
        
        for (Course course : courses) {
            courseCodes.add(course.getCouseCode());
        }
        
        return courseCodes.iterator();
    }
    
    public void enrollCourse(String idNum, String courseCode)
    {
        System.out.println("ALLAHU AKBAR");
    }
    
    public boolean canEnroll()
    {
        return true;
    }
            
}
