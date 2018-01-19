package q2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>
 * COMP 1510 assignment 3 q2.
 * </p>
 * <p>
 * The program identifies prime numbers up to the Upper bound by using the Sieve
 * of Eratosthenes Theory.
 * </p>
 *
 * @author JunHo Oh Set C.
 * @version 1.0
 */
public class Primes {

    /**
     * <p>
     * Boolean list of numbers.
     * </p>
     */
    private ArrayList<Boolean> primes;

    /**
     * <p>
     * N is the Upper bound of number list.
     * </p>
     */
    private int n;

    /**
     * <p>
     * Constructs an object of type Primes.
     * </p>
     * 
     * @param n
     *        as an integer
     */
    public Primes(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("The upper bound "
                    + "needs to be greater than 1" 
                    + "\nEnter an Upper bound:");
        } else {
            this.n = n;
        }
        primes = new ArrayList<Boolean>();
        calculatePrimes();

    }

    /**
     * <p>
     * Determine which indices are prime and which are not.
     * </p>
     * 
     */
    private void calculatePrimes() {
        for (int i = 0; i <= n; i++) {
            int count = 0;
            if (i < 2) {
                primes.add(false);
            } else {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        count++;
                    }
                }
                primes.add((count > 0) ? false : true);
            }
        }
    }

    /**
     * <p>
     * prints out the list of primes you calculated.
     * </p>
     */
    public void printPrimes() {
        for (int i = 0; i < primes.size(); i++) {
            if (primes.get(i).equals(true)) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * <p>
     * Returns an integer representing the number of primes in the range [0, N].
     * </p>
     * 
     * @return as an integer
     */
    public int countPrimes() {
        int count = 0;
        for (int i = 0; i < primes.size(); i++) {
            if (primes.get(i).equals(true)) {
                count++;
            }
        }
        return count;
    }

    /**
     * <p>
     * Returns true if x is prime and false if it is not. 
     * The parameter must be in the range [0, N].
     * </p>
     * 
     * @param x
     *            as an integer
     * @return as a boolean
     */
    public boolean isPrime(int x) {
        if (x > n) {
            throw new IllegalArgumentException("not in a range. "
                    + "Therefore, it's ");
        }
        return primes.get(x);
    }

    /**
     * <p>
     * Drives the program.
     * </p>
     *
     * @param args
     *            unused.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program uses the sieve of Eratosthenes "
                + "to determine \nwhich numbers are prime.\n\n" 
                + "Enter an Upper bound:");
        int userInput = scan.nextInt();
        Primes test = new Primes(userInput);

        System.out.println("There are " + test.countPrimes() + " primes: ");
        System.out.println("The prime numbers between 0 and " 
                + userInput + " are:");

        test.printPrimes();
        System.out.println("\n");

        System.out.println("Question two was called and ran sucessfully.");
        scan.close();
    }

};
