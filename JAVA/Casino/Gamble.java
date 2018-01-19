package table.game;

import java.text.NumberFormat;
import java.util.Random;

/**
 * Gamble.
 *
 * @author JunHo_Oh
 * @version 2017
 */
abstract public class Gamble {
    
    protected double minBet;
    protected double maxBet;
    protected double balance;
    
    /**
     * Constructs an object of type Gamble.
     * @param minBet
     * @param maxBet
     * @param balance
     */
    public Gamble(double minBet, double maxBet, double balance) {
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.balance = balance;
    }
    
    public String drawCard() {
        char[] numbers = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
        String[] suit = {"Hearts", "Clubs", "Diamonds", "Spades"};
        
        Random ran = new Random();
        char randomNumber = numbers[ran.nextInt(numbers.length - 1)];
        String randomSuit = suit[ran.nextInt(suit.length - 1)];
        
        return randomNumber + "," + randomSuit;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void buyIn(double buyIn) {
        balance += buyIn;
    }
    
    public abstract String gameType();
    

    /**
     * @see java.lang.Object#toString()
     * @return
     */
    @Override
    public String toString() {
        NumberFormat dolour = NumberFormat.getCurrencyInstance(); 
        return "Gamble [minBet=" + dolour.format(minBet) 
            + ", maxBet=" + dolour.format(maxBet) 
            + ", balance=" + dolour.format(balance) + "]";
    }
    
}
