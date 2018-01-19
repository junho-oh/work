package table.game;

import java.util.Scanner;

public class BlackJack extends Gamble{
    
    private static char[] ten = {'T','J','Q','K'};
    private static int dealerResult;
    private static int playerResult;
    
    protected String initDealerCard;
    protected String initPlayerCard1;
    protected String initPlayerCard2;
    protected double mainBet;
    protected double bountyBet;

    public BlackJack(double minBet, double maxBet, double balance) {
        super(minBet, maxBet, balance);
        initDealerCard = drawCard();
        initPlayerCard1 = drawCard();
        initPlayerCard2 = drawCard();
        mainBet = 0;
        bountyBet = 0;
    }

    public void setMainBet() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Place Main Bet Please");
        double initBet = scan.nextDouble();
        while (!(initBet >= minBet && initBet < maxBet && initBet <= balance)) {
            System.out.println("Try Again");
            initBet = scan.nextDouble();
        }
        mainBet += initBet;
        balance -= initBet;
    }
    
    public boolean isFirstTen() {
        for (char i : ten) {
            if (i == initPlayerCard1.charAt(0)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isSecondTen() {
        for (char i : ten) {
            if (i == initPlayerCard2.charAt(0)) {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean blackJackWin() {
        if (initPlayerCard1.charAt(0) == 'A') {
            if (isFirstTen()) {
                return true;
            }
        } else if (initPlayerCard2.charAt(0) == 'A') {
            if (isSecondTen()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isAce(String cards) {
        if (cards.charAt(0) == 'A') {
            return true;
        }
        return false;
    }
    
    public boolean isTen(String cards) {
        for (char i : ten) {
            if (i == cards.charAt(0)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean twoAce() {
        if (isAce(initPlayerCard1) && isAce(initPlayerCard2)) {
            return true;
        }
        return false;
    }
    
    public int initSum() {
        int sum = 0;
        if(blackJackWin()) {
            return 21;
        } else if (twoAce()) {
            return 2;
        } else if (isAce(initPlayerCard1)) {
            return 1 + (int)initPlayerCard2.charAt(0) - 48;
        } else if (isAce(initPlayerCard2)) {
            return 1 + (int)initPlayerCard1.charAt(0) - 48;
        } else if (isFirstTen() && isSecondTen()) {
            return 20;
        } else if (isFirstTen()) {
            return 10 + (int)initPlayerCard2.charAt(0) - 48;
        } else if (isSecondTen()) {
            return 10 + (int)initPlayerCard1.charAt(0) - 48;
        } else {
            return (int)initPlayerCard1.charAt(0) + (int)initPlayerCard2.charAt(0) - 96;
        }
    }
    
    public int numberValue(String card) {
        if(isAce(card)) {
            return 1;
        }
        if (isTen(card)) {
            return 10;
        }
        return (int)card.charAt(0) - 48;
    }
    
    public void dealerGetsCard() {
        String oldCard = initDealerCard;
        int sum = numberValue(oldCard);
        while(sum < 17) {
            String newCard = drawCard();
            String sumCard = oldCard + newCard;
            sum += numberValue(newCard);
            if (sum > 21) {
                System.out.println(sumCard + " : " + sum);
                System.out.println("Dealer Bust");
                dealerResult = 0;
            } else {
                System.out.println(sumCard + " : " + sum);
                oldCard = sumCard;
                
            }
        }
        if (sum <= 21) {
            dealerResult = sum;
//            System.out.println(oldCard);
//            System.out.println(numberValue(oldCard));
        }
    }
    
    public void play() {
        Scanner scan = new Scanner(System.in);
        System.out.println("welcome! Do you wanna play? type q");
        if (!scan.next().equals("q")) {
            mainBet = 0;
            setMainBet();
            System.out.println("Bet: " + mainBet + "\tBalance: " + balance 
                    + "\nHit: \"h\" , Stand: \"s\"" + "\ttype \"q\" to quit");
            
            System.out.println(initDealerCard + "\n\n");
            System.out.println(initPlayerCard1 + " + " + initPlayerCard2);
            System.out.println(initSum());
            if (blackJackWin()) {
                System.out.println("Black Jack! pays 3/2: " + (mainBet * 3/2));
                balance += mainBet * 3/2;
                playerResult = 21;
                play();
            } else {
                System.out.println("Hit or Stay");
                int sum = initSum();
                String junk;
                playerResult = sum;
                if (scan.next().equals("h")) {
                    junk = scan.next();
                    while(!scan.next().equals("s")) {
                        junk = scan.next();
                        String newCard = drawCard();
                        String oldCard = initPlayerCard1 + " + " + initPlayerCard2;
                        System.out.println(oldCard + newCard);
                        oldCard += newCard;
                        sum += numberValue(newCard);
                        System.out.println(sum);
                        playerResult = sum;
                        if (sum > 21) {
                            System.out.println("bust!");
                            playerResult = 0;
                            System.out.println("balance: " + balance);
                            break;
                        } else {
                            scan.next();
                        }
                    }
                }
                if(playerResult != 0) {
                    dealerGetsCard();
                    if (dealerResult < playerResult) {
                        balance += mainBet + mainBet;
                        System.out.println("win: +" + mainBet + " = " + balance);
                    } else if (dealerResult > playerResult) {
                        System.out.println("Loose: -" + mainBet + " = " + balance);
                    } else {
                        System.out.println("tie: " + dealerResult + " vs " + playerResult);
                    }
                }
            }
        }
        dealerResult = 0;
        playerResult = 0;
        initDealerCard = drawCard();
        initPlayerCard1 = drawCard();
        initPlayerCard2 = drawCard();
        play();
    }
    
    public void MainWin() {
        if (blackJackWin()) {
            balance += mainBet * 3/2;
        }else {
            balance += mainBet;
        }
    }
    
    public void setBountyBet() {
        Scanner scan = new Scanner(System.in);
        System.out.println("place Bounty Bet Please");
        double initBet = scan.nextDouble();
        while (!(initBet >= minBet || initBet < maxBet || initBet > balance)) {
            System.out.println("Try Again");
            initBet = scan.nextDouble();
        }
        bountyBet += initBet;
    }
    
    private int kingsBounty() {
        if(initPlayerCard1.charAt(0) == 'K' && initPlayerCard1.charAt(3) == 'S' &&
                initPlayerCard2.charAt(0) == 'K' && initPlayerCard2.charAt(3) == 'S') {
            return 125;
        }
        
        if (initPlayerCard1.charAt(0) == initPlayerCard2.charAt(0)) {
            if(initPlayerCard1.charAt(3) == initPlayerCard2.charAt(3)) {
                return 20;
            } else {
                return 9;
            }
        }
        if ((initPlayerCard1.charAt(0) == 'A' && initPlayerCard2.charAt(0) == '9') ||
                (initPlayerCard1.charAt(0) == '9' && initPlayerCard2.charAt(0) == 'A')) {
            return 4;
        }
        if (isFirstTen() && isSecondTen()) {
            return 4;
        }
        
        return 1;
    }

    @Override
    public String gameType() {
        // TODO Auto-generated method stub
        return "black Jack";
    }

}
