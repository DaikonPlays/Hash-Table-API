/**
 * Name: Kevin Yan
 * Email: kevinyan904@gmail.com
 * Sources used: tutors, java api for methods
 * 
 * This is a Student class that uses Comparable
 * to get and compare students. It records the 
 * full name and PID of the student. 
 */
import java.util.Objects;
/**
 * Student class  can compare different students.
 * It uses Comparable to compare.
 * Instance variables: firstName, the first name
 * of the student, lastName, the last name of 
 * the student, and PID, the PID of the student.
 */
public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String PID;
    /**
     * Initializes Student instance variables
     * @param firstName first name of student
     * @param lastName last name of student
     * @param PID PID of student
     */
    public Student(String firstName, String lastName, String PID) {
        if((firstName == null || lastName == null) || PID == null){
            throw new IllegalArgumentException();
        }        
        else {
            this.firstName = firstName;
            this.lastName = lastName;
            this.PID = PID;
        }
    }
    /**
     * gets String lastName
     * @return the last name of student
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * gets String firstName
     * @return the first name of student
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * gets String PID
     * @return the PID of student
     */
    public String getPID() {
        return PID;
    }
    /**
     * checks if the input o has the same
     * instance variables as the current
     * student
     * @param o object of Student
     * @return true if equal
     * @return false otherwise
     */
    public boolean equals(Object o) {
        if(o instanceof Student == true) {
            //checks if the instance variables are equal
            Student ostu = (Student) o;
            if(this.getFirstName().equals(ostu.getFirstName()) && this.getLastName().equals(ostu.getLastName()) && this.getPID().equals(ostu.getPID())) {
                return true;
            }
        }
        return false;
    }
    /**
     * generates hash value of the Object
     * @return the hash value of the Object
     */
    public int hashCode() {
        return Objects.hash(firstName, lastName, PID);
    }
    /**
     * compares input student to this student
     * @param o student to be compared
     * @return compareTo output for firtName,
     * lastName, and PID
     */
    public int compareTo(Student o) {
        //uses compareTo to compare the students
        int last = this.lastName.compareTo(o.lastName);
        int first = this.firstName.compareTo(o.firstName);
        int PID = this.PID.compareTo(o.PID);
        if(last == 0 && first == 0 && PID == 0) {
            return 0;
        }
        if(last != 0) {
            return last; 
        }
        if(first != 0) {
            return first;
        }
        return PID;
    }
}
