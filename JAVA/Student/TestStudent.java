package q3;

import java.util.ArrayList;
import java.util.Random;

/**
 * <p>
 * COMP 1510 assignment 3 q3.
 * </p>
 * <p>
 * TestStudent sets all students into the list and modifies unknown student's
 * information.
 * </p>
 *
 * @author JunHo Oh Set C.
 * @version 1.0
 */
public class TestStudent {

    /**
     * <p>
     * Number of total student.
     * </P>
     */
    private static final int NUM_STUDENT = 3;

    /**
     * <p>
     * Maximum test score.
     * </p>
     */
    private static final int MAX_SCORE = 101;

    /**
     * <p>
     * Index of new unknown student in the list.
     * </p>
     */
    private static final int NEW_STUDENT = 3;

    /**
     * <p>
     * Version3 of Test.
     * </p>
     */
    private static final int TEST_3 = 3;

    /**
     * <p>
     * Test one score.
     * </p>
     */
    private static final int SCORE1 = 100;

    /**
     * <p>
     * Test two score.
     * </p>
     */
    private static final int SCORE2 = 86;

    /**
     * <p>
     * Test Three score.
     * </p>
     */
    private static final int SCORE3 = 79;

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
        String[] first = { "James", "Kevin", "Nicole" };
        String[] last = { "Oh", "Kim", "Smith" };

        ArrayList<Student> studentGroup = new ArrayList<Student>();
        Random ranScore = new Random();

        // Creates 3 random Students with random data and
        // Adds them to StudentGroup ArrayList.
        for (int i = 0; i < NUM_STUDENT; i++) {
            studentGroup.add(new Student(first[i], last[i], 
                    home, bcit, ranScore.nextInt(MAX_SCORE),
                    ranScore.nextInt(MAX_SCORE), ranScore.nextInt(MAX_SCORE)));
        }
        // Creates and adds unknown student.
        studentGroup.add(new Student());

        // Prints Student List.
        for (Student i : studentGroup) {
            System.out.println(i + "\n");
        }

        System.out.println("Unknown student is found, Let's modify it!");

        studentGroup.get(NEW_STUDENT).setFirstName("Jason");
        studentGroup.get(NEW_STUDENT).setLastName("Lee");
        studentGroup.get(NEW_STUDENT).setHomeAddress(home);
        studentGroup.get(NEW_STUDENT).setSchoolAddress(bcit);
        studentGroup.get(NEW_STUDENT).setTestScore(1, SCORE1);
        studentGroup.get(NEW_STUDENT).setTestScore(2, SCORE2);
        studentGroup.get(NEW_STUDENT).setTestScore(TEST_3, SCORE3);
        System.out.println(
                "\nThe unknown student is modified:\n" + "First Name: " 
                        + studentGroup.get(NEW_STUDENT).getFirstName()
                        + "\nLast Name: "
                        + studentGroup.get(NEW_STUDENT).getLastName() 
                        + "\nHome Address: "
                        + studentGroup.get(NEW_STUDENT).getHomeAddress() 
                        + "\nSchool Address: "
                        + studentGroup.get(NEW_STUDENT).getSchoolAddress() 
                        + "\nTest1 Score: "
                        + studentGroup.get(NEW_STUDENT).getTestScore(1) 
                        + "\nTest2 Score: "
                        + studentGroup.get(NEW_STUDENT).getTestScore(2) 
                        + "\nTest3 Score: "
                        + studentGroup.get(NEW_STUDENT).getTestScore(TEST_3) 
                        + "\nThe average: "
                        + studentGroup.get(NEW_STUDENT).average());

        System.out.println("Question three was called and ran sucessfully.");
    }

};
