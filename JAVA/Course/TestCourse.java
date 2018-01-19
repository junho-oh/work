package q4;

import java.util.Random;

import q3.Address;
import q3.Student;

/**
 * <p>
 * COMP 1510 assignment 3 q4.
 * </p>
 * <p>
 * TestCourse creates a course, adds several students, prints a roll, and prints
 * the overall course test average.
 * </p>
 *
 * @author JunHo Oh Set C.
 * @version 1.0
 */
public class TestCourse {

    /**
     * <p>
     * Maximum occupancy of the course.
     * </p>
     */
    private static final int NUM_STUDENT = 5;
    
    /**
     * <p>
     * Maximum score of each test.
     * </p>
     */
    private static final int MAX_SCORE = 101;

    /**
     * <p>
     * Drives the program.
     * </p>
     *
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        Address home = new Address("3663 Crowley Dr", 
                "Vancouver", "BC", "V5R 6H4");
        Address bcit = new Address("3700 Willingdon Ave", 
                "Burnaby", "BC", "V5G 3H2");
        String[] first = { "James", "Kevin", "Nicole", "Sophie", "Helen" };
        String[] last = { "Oh", "Kim", "Smith", "Lee", "Henderson" };

        Course courseOne = new Course("JAVA");
        Random ranScore = new Random();
        for (int i = 0; i < NUM_STUDENT; i++) {
            courseOne.addStudent(new Student(first[i], last[i], 
                    home, bcit, ranScore.nextInt(MAX_SCORE),
                    ranScore.nextInt(MAX_SCORE), ranScore.nextInt(MAX_SCORE)));
        }
        
        // IllegalArgument will show
        // if bottom code is execute. Because it is adding student more than 5
        /*
        courseOne.addStudent(new Student("James", "Oh", 
                home, bcit, 1, 0, 2));
                */

        System.out.println("The average of all students’ test score" 
                + "averages: " + courseOne.average());
        System.out.print("\nAll students in the course: ");
        courseOne.roll();

        System.out.println("Question four was called and ran sucessfully.");
    }

};
