import java.util.*;
import java.io.*;

public class NumberGame {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();
    public static void main(String[] args) {
        NumberGame n = new NumberGame();
        n.list(scoreBoard);
    }
    public void list(ArrayList<Integer> scoreBoard) {
        NumberGame n = new NumberGame();
        Scanner input = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        System.out.println("Number Guessing Game");
        System.out.println("1) Begin Game");
        System.out.println("2) Display Score");
        System.out.println("3) Exit ");
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        try {
            System.out.print("\n Select any of the above option to be performed? \n");
            int menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.print("\n What would you like the range of the numbers to be? \n ");
                    int numberRange = input.nextInt();
                    int randomNumber = n.randomNumber(numberRange);
                    n.guessNumber(randomNumber);
                    break;
                case 2:
                    n.displayScore();
                    break;
                case 3:
                    System.out.println("\n ");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("\n Error!! , Try Again....\n");
            }
        }catch(InputMismatchException exc){
            System.err.println("\n"+exc.getMessage() +"\n");
            list(scoreBoard);
        }
    }
    public int randomNumber(int numberRange) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(numberRange) + 1;
        return randomNumber;
    }
    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Enter your guessed number: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > randomNumber) {
                System.out.println("Lower");
            } else if (userGuess < randomNumber) {
                System.out.println("Higher");
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You guessed the number in " + guess + " try!");
        } else {
            System.out.println("You guessed number in " + guess + " tries!");
        }
        scoreBoard.add(guess);
        System.out.println(" ");

        list(scoreBoard);
    }
    public void displayScore() {
        System.out.println("-x--x--x--x--x--x--x-");
        System.out.println("Score Board");
        System.out.println("-x--x--x--x--x--x--x-");
        System.out.println("\n Your fastest games today out of all tries is: \n");
        Collections.sort(scoreBoard);
        for (Integer scores : scoreBoard) {
            System.out.println("Completed the Game with " + scores + " tries");
        }
        System.out.println(" ");
        list(scoreBoard);
    }
}
