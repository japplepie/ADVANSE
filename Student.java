import java.util.ArrayList;
import java.util.Iterator;

public class Student {
    private String idNum;
    private String name;
    private ArrayList<Course> enrolledCourses;
    private int maxUnits;
    
    public Student(String idNum, String name){
        this.idNum = idNum;
        this.name = name;
        this.enrolledCourses = new ArrayList<Course>();
        this.maxUnits = 9;
    }
    
    public String getID(){
        return this.idNum;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Iterator<Course> getEnrolledCourses(){
        return this.enrolledCourses.iterator();
    }
    
    public int getMaxUnits(){
        return this.maxUnits;
    }
    
}
