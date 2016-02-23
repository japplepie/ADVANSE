import java.util.ArrayList;
import java.util.Iterator;

public class Course {
    private String courseCode;
    private int units;
    private int max;
    
    
    public Course(String courseCode, int units, int max){
        this.courseCode = courseCode;
        this.units = units;
        this.max = max;
        
    }
    
    public Course(String courseCode, int units, ArrayList<Student> students){
        this.courseCode = courseCode;
        this.units = units;
    
    }
    
    public String getCouseCode(){
        return this.courseCode;
    }
    
    public int getUnits(){
        return this.units;
    } 
    
    
    public int getMax(){
        return this.max;
    }
}
