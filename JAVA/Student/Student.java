package q3;

/**
 * Represents a BCIT student.
 * 
 * @author Lewis & Loftus 9e & JunHo Oh Set C.
 * @author BCIT
 * @version 2017
 */
public class Student {
    /**
     * The Final value of number of test Scores.
     */
    public static final int NUM_SCORE = 3;
    
    /** First name of this student. */
    private String firstName;

    /** Last name of this student. */
    private String lastName;

    /** Home address of this student. */
    private Address homeAddress;

    /** School address of this student. Can be shared by other students */
    private Address schoolAddress;

    /**
     * <p>
     * Score of test1 of this student.
     * </p>
     */
    private int testScore1;

    /**
     * <p>
     * Score of test2 of this student.
     * </p>
     */
    private int testScore2;

    /**
     * <p>
     * Score of test3 of this Student.
     * </p>
     */
    private int testScore3;

    /**
     * Constructs a Student object that contains the specified values.
     * 
     * @param firstName
     *            a String representing the first name
     * @param lastName
     *            a String representing the last name
     * @param homeAddress
     *            an Address object containing the home address
     * @param schoolAddress
     *            an Address object containing the school address
     * @param testScore1
     *            an integer representing the test1 score
     * @param testScore2
     *            an integer representing the test2 score
     * @param testScore3
     *            an integer representing the test3 score
     */
    public Student(String firstName, String lastName, 
            Address homeAddress, Address schoolAddress, 
            int testScore1, int testScore2, int testScore3) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.schoolAddress = schoolAddress;
        this.testScore1 = testScore1;
        this.testScore2 = testScore2;
        this.testScore3 = testScore3;
    }

    /**
     * Constructs an object of type Student.
     */
    public Student() {
        firstName = "";
        lastName = "";
        homeAddress = null;
        schoolAddress = null;
        testScore1 = 0;
        testScore2 = 0;
        testScore3 = 0;
    }

    /**
     * Returns the firstName for this Student.
     * 
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the firstName for this Student.
     * 
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the lastName for this Student.
     * 
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the lastName for this Student.
     * 
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the homeAddress for this Student.
     * 
     * @return the homeAddress
     */
    public Address getHomeAddress() {
        return homeAddress;
    }

    /**
     * Sets the homeAddress for this Student.
     * 
     * @param homeAddress
     *            the homeAddress to set
     */
    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * Returns the schoolAddress for this Student.
     * 
     * @return the schoolAddress
     */
    public Address getSchoolAddress() {
        return schoolAddress;
    }

    /**
     * Sets the schoolAddress for this Student.
     * 
     * @param schoolAddress
     *            the schoolAddress to set
     */
    public void setSchoolAddress(Address schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    /**
     * <p>
     * Sets the test score for this Student.
     * </p>
     * 
     * @param testNumber
     *            the test Number to set.
     * @param score
     *            the score to set.
     */
    public void setTestScore(int testNumber, int score) {
        if (testNumber == 1) {
            testScore1 = score;
        } else if (testNumber == 2) {
            testScore2 = score;
        } else if (testNumber == NUM_SCORE) {
            testScore3 = score;
        } else {
            throw new IllegalArgumentException("Choose between 1, 2 or 3");
        }
    }

    /**
     * <p>
     * Returns the right testScore.
     * </p>
     * 
     * @param testNumber
     *            as an integer
     * @return as integer
     */
    public int getTestScore(int testNumber) {
        if (testNumber == 1) {
            return testScore1;
        } else if (testNumber == 2) {
            return testScore2;
        } else if (testNumber == NUM_SCORE) {
            return testScore3;
        } else {
            throw new IllegalArgumentException("Choose between 1, 2 or 3");
        }
    }

    /**
     * <p>
     * Returns the average of this Student.
     * </p>
     * 
     * @return as an integer
     */
    public int average() {
        return (testScore1 + testScore2 + testScore3) / NUM_SCORE;
    }

    /**
     * <p>
     * Returns a description of this Student object.
     * </p>
     * 
     * @see java.lang.Object#toString()
     * @return as a String
     */
    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", lastName=" + lastName 
                + ", "  + "homeAddress=" + homeAddress 
                + ", schoolAddress=" + schoolAddress
                + ", testScore1=" + testScore1 
                + ", testScore2=" + testScore2
                + ", testScore3=" + testScore3 + "]";
    }
}
