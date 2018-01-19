package q3;

import java.util.Scanner;

/**
 * <p>
 * COMP 1510 assignment 4 q3.
 * </p>
 * <p>
 * The program reads a line from the input, and prints an error message if any
 * characters are invalid MIX characters. If all the characters are MIX
 * characters, convert them to have the correct numerical values, then encode
 * them in to a long array and print out the long array. Then decode the long
 * array, convert the MIXChar characters to a Java string and print out the
 * resulting Java String.
 * </p>
 *
 * @author JunHo Oh
 * @version 1.0
 */
public final class MIXChar {

    /**
     * <P>
     * Final character value of DELTA character.
     * </P>
     */
    private static final char DELTA = '\u0394';

    /**
     * <P>
     * Final character value of SIGMA character.
     * </P>
     */
    private static final char SIGMA = '\u03A3';

    /**
     * <P>
     * Final character value of PI character.
     * </P>
     */
    private static final char PI = '\u03A0';

    /**
     * <p>
     * Final value of packed MIXChar character per long.
     * </p>
     */
    private static final int CHAR_PER_LONG = 11;

    /**
     * <p>
     * Final value of length of mixCharArray.
     * </p>
     */
    private static final int BASE = 56;

    /**
     * <p>
     * THe max value of power of the BASE.
     * </p>
     */
    private static final int POWER = 10;

    /**
     * <P>
     * The char array of the MIXChar character in order.
     * </p>
     */
    private static char[] mixCharArray = {
            ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', DELTA, 'J', 
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', SIGMA, PI, 'S', 'T', 
            'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', '.', ',', '(', ')', '+', '-', '*', '/', 
            '=', '$', '<', '>', '@', ';', ':', '\'' };

    /**
     * An index of mixCharArray.
     */
    private static int index;

    /**
     * value is the value of MIXChar.
     */
    private int value;

    /**
     * <p>
     * Constructs an object of type MIXChar.
     * </p>
     * 
     * @param value
     *            as an int.
     */
    private MIXChar(int value) {
        this.value = value;
    }

    /**
     * Returns the value for this MIXChar.
     * 
     * @return the value
     */
    public int ordinal() {
        return value;
    }

    /**
     * Returns true if the c corresponds to a MIXChar Character,
     * false otherwise.
     * 
     * @param c
     *            as a char.
     * @return as a boolean
     */
    public static boolean isMIXChar(char c) {
        index = 0;
        for (char i : mixCharArray) {
            if (c == i) {
                return true;
            }
            index++;
        }
        return false;
    }

    /**
     * Returns MIXChar after converting c to the corresponding MIXChar.
     * 
     * @param c
     *            as a char
     * @return as a MIXChar
     */
    public static MIXChar toMIXChar(char c) {
        if (isMIXChar(c)) {
            return new MIXChar(index);
        } else {
            throw new IllegalArgumentException(c 
                    + " is not a MIXChar Character.");
        }
    }

    /**
     * Returns Java char after converting x MIXChar character.
     * 
     * @param x
     *            as MIXchar
     * @return as a char
     */
    public static char toChar(MIXChar x) {
        return mixCharArray[x.ordinal()];
    }

    /**
     * Returns String with characters corresponding to those of the input array.
     * 
     * @param x
     *            as a MIXChar array
     * @return as a String
     */
    static String toString(MIXChar[] x) {
        String str = "";
        for (MIXChar a : x) {
            str += toChar(a);
        }
        return str;
    }

    /**
     * Return array of MIXChar characters corresponding to the chars in s.
     * 
     * @param s
     *            as a String
     * @return as MIXChar[]
     */
    static MIXChar[] toMIXChar(String s) {
        MIXChar[] array = new MIXChar[s.length()];
        for (int i = 0; i < s.length(); i++) {
            array[i] = toMIXChar(s.charAt(i));
        }
        return array;
    }

    /**
     * Returns an array of long's holding the values of the m packed 11 MIXChar
     * characters per long.
     * 
     * @param m
     *            as a MIXChar[]
     * @return as a long[]
     */
    static long[] encode(MIXChar[] m) {
        int size = ((m.length % CHAR_PER_LONG == 0) 
                ? (m.length / CHAR_PER_LONG) : (m.length / CHAR_PER_LONG + 1));
        long[] packed = new long[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; count < CHAR_PER_LONG && j 
                    + (i * CHAR_PER_LONG) != m.length; j++) {
                packed[i] += m[j + (i * CHAR_PER_LONG)].ordinal() 
                        * (long) Math.pow(BASE, (POWER - j));
                count++;
            }
            count = 0;
        }
        return packed;
    }

    /**
     * Returns a MIXChar array with the characters unpacked from the long array.
     * 
     * @param l
     *            as long[]
     * @return as a MIXChar[]
     */
    static MIXChar[] decode(long[] l) {
        int size = l.length * CHAR_PER_LONG;
        MIXChar[] unpacked = new MIXChar[size];
        for (int i = 0; i < l.length; i++) {
            long currentLong = l[i];
            for (int j = 0; j < CHAR_PER_LONG; j++) {
                unpacked[j + (i * CHAR_PER_LONG)] = new MIXChar(
                        (int) Long.divideUnsigned(currentLong, 
                                (long) (Math.pow(BASE, POWER - j))));
                currentLong = Long.remainderUnsigned(currentLong, 
                        (long) Math.pow(BASE, POWER - j));
            }
        }
        return unpacked;
    }

    /**
     * Returns string containing this MIXChar as a Java char.
     * 
     * @see java.lang.Object#toString()
     * @return as a String
     */
    @Override
    public String toString() {
        return "MIXChar [value=" + mixCharArray[value] + "]";
    }

    /**
     * <p>
     * Drives the program.
     * </p>
     *
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();

        try {
            MIXChar[] test = toMIXChar(userInput);
            System.out.println("The numerical value of \"" 
                    + userInput + "\" :");
            for (MIXChar i : test) {
                System.out.print(i.ordinal() + " ");
            }

            System.out.println("\n\nEncode in the long[]: ");
            long[] longArray = encode(test);
            for (int i = 0; i < longArray.length; i++) {
                System.out.println("long[" + i + "] : " + longArray[i]);
            }

            MIXChar[] decodedArray = decode(longArray);
            System.out.println("\nDecode: \n" + toString(decodedArray));

            scan.close();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println("Question three was called and ran sucessfully.");
    }
}
