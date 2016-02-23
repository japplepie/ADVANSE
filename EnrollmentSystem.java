
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
    DBUtil db;
    public EnrollmentSytem(){
        db = new DBUtil();
        
    }
    
    public ArrayList<Course> viewAllCourses(){
        ArrayList<Course> courses = new ArrayList<Course>();
        try{
            Connection  con= db.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * from course");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Course tempCourse = new Course(rs.getString("code"), rs.getInt("units"), rs.getInt("max"));
                courses.add(tempCourse);  
            }
        }
        catch(Exception se){       	}
        
        return courses;
    }
    
    public ArrayList<Course> viewAllEnrolledCourses(String idNum){
        ArrayList<Course> courses = new ArrayList<Course>();
        
        try{
            Connection  con= db.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * from course, student_course WHERE course.code = student_course.code AND student_course.id = '" + idNum + "'");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Course tempCourse = new Course(rs.getString("code"), rs.getInt("units"), rs.getInt("max"));
                courses.add(tempCourse);  
            }
        }
        catch(Exception se){       	}
        return courses;
    }
    
    public boolean checkLogin(String idNum, String password){
        
        try{
            Connection  con= db.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * from student WHERE idNum = '" + idNum + "' AND password = '" + password +"'");
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return true;
            }
        }catch(Exception se){}
        return false;
    }
    
    public boolean checkID(String idNum){
        try{
            Connection  con= db.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT id from student");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(idNum.equals(rs.getString("id"))){
                    return false;
                }
            }
        }catch(Exception se){}
        return true;
    }
    
    public boolean register(Student student, String password){
        String name, idNum;
        name = student.getName();
        idNum = student.getID();
        if(checkID(idNum)){
            try{
            Connection  con= db.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO student (`fullname`, `id`, `password`) VALUES(?,?,?)");
            ps.setString(1, name);
            ps.setString(2, idNum);
            ps.setString(3, password);
            
            int rs = ps.executeUpdate();
            if(rs>0){
                return true;
            }
        }catch(Exception se){}
        }
        return false;
    }
    
    public boolean enrollCourse(String idNum, String courseCode){
        if(canEnroll(idNum, courseCode)){
            try{
            Connection  con= db.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO student_course (`id`, `code`) VALUES(?,?)");
            ps.setString(1, idNum);
            ps.setString(2, courseCode);
            
            int rs = ps.executeUpdate();
            if(rs>0){
                return true;
            }
        }catch(Exception se){}
        }
        return false;
    }
    
    public boolean canEnroll(String idNum, String courseCode){
        if(checkCourseCode(courseCode)){
            if(checkStudentMax(idNum) && checkCourseMax(courseCode)){
                return true;
            } else return false;
        }else return false;
    }
    
    private boolean checkCourseCode(String courseCode){
        try{
            Connection  con= db.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * from course WHERE code = '" + courseCode +"'");
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return true;
            }
        }catch(Exception se){}
        return false;
    }
    
    private boolean checkCourseMax(String courseCode){
        int max = 0, curr = 0;
        try{
            Connection  con= db.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT max from course WHERE code = '" + courseCode +"'");
            ResultSet rs = ps.executeQuery();
            rs.next();
            max = rs.getInt("max");
        }catch(Exception se){}
        
        try{
            Connection  con= db.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT count(*) AS benjobobo from student_course WHERE code = '" + courseCode +"'");
            ResultSet rs = ps.executeQuery();
            rs.next();
            curr  = rs.getInt("benjobobo");
        }catch(Exception se){}
        
        if(curr < max){
            return true;
        }else return false;
    }
    
    private boolean checkStudentMax(String idNum){
        int max = 0, curr = 0;
         try{
            Connection  con= db.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT count(*) AS benjobobo from student_course WHERE id = '" + idNum +"'");
            ResultSet rs = ps.executeQuery();
            rs.next();
            curr  = rs.getInt("benjobobo");
        }catch(Exception se){}
         
        if(curr < 9){
            return true;
        }else return false;
    }
   
    
    public boolean dropCourse(String idNum, String courseCode){
        if(checkCourseCode(courseCode)){
            try{
            Connection  con= db.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE from student_course WHERE id = '" + idNum +"' AND code='" + courseCode +"'");
            int rs = ps.executeUpdate();
            if(rs>0){
                return true;
            }
            }catch(Exception se){}
        }
        return false;
    }
    
    
}
