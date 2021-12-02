import java.util.Random;
import java.util.Scanner;

public class Lottery {
    int winningNumber;
    int userGuess;

    public Lottery(int guess) {
        this.userGuess = guess;
        Random rando = new Random();
        this.winningNumber = rando.nextInt(99);

    }

    
    /** 
     * @return String
     */
    String checkUserAnswer() {
        String output = "Better luck next time";
        String userDigits = String.format("%02d", this.userGuess);
        String winningDigits = String.format("%02d", this.winningNumber);

        System.out.println(winningDigits);

        if (userDigits.length() > 2) {
            output = "You no enter two digit number";
        }
        if (userDigits.equals(winningDigits)) {
            output = "You win $10000";
        } else if (winningDigits.charAt(0) == userDigits.charAt(1) && winningDigits.charAt(1) == userDigits.charAt(0)) {
            output = "You win $3000";
        } else if (winningDigits.contains(userDigits.substring(0)) || winningDigits.contains(userDigits.substring(1))) {
            output = "You win $1000";
        } else {
            output = "Better luck next time";
        }

        return output;
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);
        System.out.println("Enter any two digit number");
        int userGuess = keyIn.nextInt();

        Lottery lottery = new Lottery(userGuess);

        System.out.println(lottery.checkUserAnswer());

        keyIn.close();
    }

}
