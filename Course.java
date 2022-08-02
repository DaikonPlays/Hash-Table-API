/**
 * Name: Kevin Yan
 * Email: kevinyan904@gmail.com
 * Sources used: tutors, java api for methods
 * 
 * This defines the details of the Course.
 * It contains Students that are enrolled.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
/**
 * defines the course details and manipulates the students
 * in the course.
 * Instance variables: 
 * enrolled, hash set of students in course
 * department of the course
 * number of the course
 * description of the course
 * formatting is used to format a return string
 */
public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;
    private final String formatting = "%s %s [%d]\n%s";
    /**
     * initializes the instance variables
     * @param department of the course
     * @param number of the course
     * @param description of the course
     * @param capacity of the course
     */
    public Course(String department, String number, String description, 
        int capacity){
            if(department == null|| number == null|| description == null){
                throw new IllegalArgumentException();
            }

            if(capacity <= 0){
                throw new IllegalArgumentException();
            }
            enrolled = new HashSet<Student>();
            this.department = department;
            this.number = number;
            this.description = description;
            this.capacity = capacity;
        }
    /**
     * gets String department
     * @return department of the course
     */    
    public String getDepartment(){
        return department;
    }
    /**
     * gets String number
     * @return number of the course
     */   
    public String getNumber(){
        return number;
    }
    /**
     * gets String description 
     * @return description of the course
     */   
    public String getDescription(){
        return description;
    }
    /**
     * gets String capacity
     * @return capacity of the course
     */   
    public int getCapacity(){
        return capacity;
    }
    /**
     * enrolls the input student into the course if 
     * not full
     * @param student to be enrolled
     * @return true if student is enrolled
     * @return false otherwise
     */
    public boolean enroll(Student student) {
        if(student == null) {
            throw new IllegalArgumentException();
        }
        //calls isFull method to enroll
        if(isFull() == false) {
            return enrolled.add(student);
        }
        else{
            return false;
        }
    }
    /**
     * removes the enrolled student from the course
     * @param student to be removed
     * @return true if student is removed
     * @return false otherwise 
     */
    public boolean unenroll(Student student) {
        if(student == null) {
            throw new IllegalArgumentException();
        }
        //check if student is enrolled
        if(enrolled.contains(student)) {
            //removes the student
            return enrolled.remove(student);
        }
        else{
            return false;
        }
    }
    /**
     * clears all students from the course
     */
    public void cancel() {
        enrolled.clear();
    }
    /**
     * checks if the course is full
     * @return true if full
     * @return false otherwise
     */
    public boolean isFull() {
        if(capacity == enrolled.size()) {
            return true;
        }
        return false;
    }
    /**
     * gets the enrolled number
     * @return how many ppl are enrolled
     */
    public int getEnrolledCount() {
        return enrolled.size();
    }
    /**
     * gets how many seats are free
     * @return available seats
     */
    public int getAvailableSeats() {
        return capacity - enrolled.size();
    }
    /**
     * returns hashset of students
     * @return shallow copy of all students enrolled
     */
    public HashSet<Student> getStudents() {
        return (HashSet<Student>) enrolled.clone();
    }
    /**
     * converts the set to an ArrayList
     * @return the converted ArrayList
     */
    public ArrayList<Student> getRoster() {
        ArrayList<Student> enrolledarrlist = new ArrayList<>();
        //creates an iterator 
        Iterator<Student> enrollit = enrolled.iterator();
        for(int i = 0; i < enrolled.size(); i++) {
            //adds the student to the ArrayList by the iterator
            enrolledarrlist.add(enrollit.next());
        }
        //sorts the ArrayList
        Collections.sort(enrolledarrlist);
        return enrolledarrlist;
    }
    /**
     * formats the course and returns it
     * @return formatted course string
     */
    public String toString() {
        //uses format() to format the string in one line
        String dep = String.format(formatting, getDepartment(), getNumber(), getCapacity(), getDescription());
        return dep;
    }
}

