import java.util.ArrayList;
import java.util.Iterator;

public class Course {
    private String courseCode;
    private int units;
    private ArrayList<Student> enrolledStudents;
    
    public Course(String courseCode, int units){
        this.courseCode = courseCode;
        this.units = units;
        this.enrolledStudents = new ArrayList<Student>();
    }
    
    public Course(String courseCode, int units, ArrayList<Student> students){
        this.courseCode = courseCode;
        this.units = units;
        this.enrolledStudents = students;
    }
    
    public String getCouseCode(){
        return this.courseCode;
    }
    
    public int getUnits(){
        return this.units;
    } 
    
    public Iterator<Student> getEnrolledStudents(){
        return this.enrolledStudents.iterator();
    }
    
}
