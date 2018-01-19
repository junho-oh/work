package q4;

import java.util.ArrayList;
import q3.Student;

/**
 * <p>
 * COMP 1510 assignment 3 q4.
 * </p>
 * <p>
 * Represents Course
 * </p>
 *
 * @author JunHo_Oh Set C.
 * @version 2017
 */
public class Course {

    /**
     * <p>
     * Maximum occupancy of Course.
     * </p>
     */
    public static final int MAX_STUDENT = 5;

    /**
     * <p>
     * Student List of Course.
     * </p>
     */
    private ArrayList<Student> studentGroup;

    /**
     * <p>
     * Name of the Course.
     * </p>
     */
    private String courseName;
    
    /**
     * <p>
     * Occupancy of the Course.
     * </P>
     */
    private int occupancy;

    /**
     * <p>
     * Constructs an object of type Course.
     * </p>
     * 
     * @param courseName
     *            as a String.
     */
    public Course(String courseName) {
        this.courseName = courseName;
        occupancy = 0;
        studentGroup = new ArrayList<Student>(MAX_STUDENT);
    }

    /**
     * <p>
     * Adds students in the studentGroup.
     * </p>
     * 
     * @param newStudent
     *            as Student.
     */
    public void addStudent(Student newStudent) {
        if (occupancy < MAX_STUDENT) {
            studentGroup.add(newStudent);
            occupancy++;
        } else {
            throw new IllegalArgumentException("Course is full");
        }
    }

    /**
     * <p>
     * Returns the average of all students’ test score averages.
     * </p>
     * 
     * @return totalAverage as an integer.
     */
    public int average() {
        int totalAverage = 0;
        for (Student i : studentGroup) {
            totalAverage += i.average();
        }
        return totalAverage / studentGroup.size();
    }

    /**
     * <p>
     * Prints all students in the course.
     * </p>
     */
    public void roll() {
        System.out.println(courseName);
        for (Student i : studentGroup) {
            System.out.println(i + "\n");
        }
    }
}
