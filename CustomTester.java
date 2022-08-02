/**
 * Name: Kevin Yan
 * Email: kevinyan904@gmail.com
 * Sources used: none
 * 
 * Custom testers made for PA5. 
 * I focused on edge cases.
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * Class of custom testers. They test the methods used in 
 * Course.java, Sanctuary.java, and Student.java.
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {

    // ----------------Student class----------------
    /**
     * Test the equals method when only one variable isn't equal
     */
    @Test
    public void testEquals() {
        Student student = new Student(new String("Kevin"), 
            new String("Yan"), new String("A16838244"));
        Student student1 = new Student(new String("Kevin"), 
        new String("Yeah"), new String("A16838244"));
        assertFalse(student.equals(student1));
    }

    /**
     * Test the compareTo method when only last name is different
     */
    @Test
    public void testCompareTo() {
        Student student = new Student(new String("Kevin"), 
        new String("Yan"), new String("A16838244"));
    Student student1 = new Student(new String("Jarvin"), 
    new String("Kayn"), new String("A16838244"));
    assertEquals(14, student.compareTo(student1));
    }

    // ----------------Course class----------------
    /**
     * Test the enroll method when student is null
     */
    @Test
    public void testEnroll() {
        boolean test = false;
        Course course = new Course("Math", "18", 
        "Linear Algebra", 300);
        course.enrolled = new HashSet<>();
        try{
            course.enroll(null);
        }
        catch(Exception e) {
            test = true;            
        }
        assertTrue(test);
    }

    /**
     * Test the unenroll method when student is null
     */
    @Test
    public void testUnenroll() {
        boolean test = false;
        Course course = new Course("CSE", "20", 
        "Discrete Mathematics", 300);
        course.enrolled = new HashSet<>();
        try{
            course.unenroll(null);
        }
        catch(Exception e) {
            test = true;            
        }
        assertTrue(test);
    }

    /**
     * Test the getRoster method when there are 3 in the course
     */
    @Test
    public void testGetRoster() {
        ArrayList<Student> actual = new ArrayList<>();
        Course course = new Course("Math", "18", 
        "Linear Algebra", 10);
        course.enrolled = new HashSet<>();
        course.enrolled.add(new Student("Kevin", "Yan", "A16838244"));
        course.enrolled.add(new Student("Bob", "Jones", "A382752"));
        course.enrolled.add(new Student("Will", "Smith", "A238508"));
        actual.add(new Student("Bob", "Jones", "A382752"));
        actual.add(new Student("Will", "Smith", "A238508"));
        actual.add(new Student("Kevin", "Yan", "A16838244"));

        assertEquals(actual, course.getRoster());
    }

    // ----------------Sanctuary class----------------
    /**
     * Test the constructor when maxAnimal is < 0
     */
    @Test
    public void testSanctuaryConstructor() {
        boolean test = false;
        try{
            Sanctuary san = new Sanctuary(-10, 10);
        }
        catch(Exception e) {
            test = true;            
        }
        assertTrue(test);
    }

    /**
     * Test the rescue method when num is 0 
     */
    @Test
    public void testRescueTestOne(){
        Sanctuary san = new Sanctuary(10, 10);
        boolean test = false;
        try{
            san.rescue("dog", 0);
        }
        catch(Exception e) {
            test = true;            
        }
        assertTrue(test);
    }

    /**
     * Test the rescue method when species is null
     */
    @Test
    public void testRescueTestTwo(){
        Sanctuary san = new Sanctuary(10, 10);
        boolean test = false;
        try{
            san.rescue(null, 3);
        }
        catch(Exception e) {
            test = true;            
        }
        assertTrue(test);
    }




    /**
     * Test the release method when species does not exist
     */
    @Test
    public void testReleaseTestOne(){
        Sanctuary san = new Sanctuary(10, 5);
        san.sanctuary.put("Dog", 2);
        san.sanctuary.put("Cat", 3);
        boolean test = false;
        try{
            san.release("Bird", 3);
        }
        catch(Exception e) {
            test = true;
        }
        assertTrue(test);
    }

    /**
     * Test the release method when num is greater than max animals
     */
    @Test
    public void testReleaseTestTwo(){
        Sanctuary san = new Sanctuary(10, 5);
        san.sanctuary.put("Dog", 2);
        san.sanctuary.put("Cat", 3);
        boolean test = false;
        try{
            san.release("Cat", 50);
        }
        catch(Exception e) {
            test = true;
        }
        assertTrue(test);
    }
}

