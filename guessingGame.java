import java.util.Random;
import java.util.Scanner;

public class guessingGame {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        boolean cIsValid = false;
        String[] diff = {"Easy", "Medium", "Hard"};
        int c = 0;



        System.out.println("Welcome to the Number Guessing Game!\nI'm thinking of a number between 1 and 100.\n\nPlease select the difficulty level:" +
                            "\n1. Easy (10 chances)" +
                            "\n2. Medium (5 chances)" + 
                            "\n3. Hard (3 chances)");
        do {
            try {
                System.out.print("\nEnter your choice: ");
                c = Integer.valueOf(scan.nextLine());
                if (c > 0 && c < 4) {
                    cIsValid = true;
                } else {
                    System.out.println("Please enter a number from 1-3!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Sorry, that was not a valid input. Please try again!");
            }
        } while (!cIsValid);

        System.out.println("Great! You have selected the " + diff[c-1] + " difficulty!\nLet's start the game.\n");
        
        int attempts = Math.round(10/c);
        int ans = rand.nextInt(101);
        int g = 0;;

        do {
            try {
                System.out.print("\nEnter your guess: ");
                g = Integer.valueOf(scan.nextLine());
                if (g > -1 && g < 101) {
                    attempts--;
                    if (g > ans) {
                        System.out.println("Incorrect! The number is less than " + String.valueOf(g));
                        if (attempts == 0) {
                            System.out.println("Game Over");
                        }
                    } else if (g < ans) {
                        System.out.println("Incorrect! The number is greater than " + String.valueOf(g));
                        if (attempts == 0) {
                            System.out.println("Game Over");
                        }
                    } else {
                        System.out.println("Congrats! You guessed the correct number in " + String.valueOf(10 - attempts) + " attempts!");
                        attempts = 0;
                    }
                } else {
                    System.out.println("Please enter a number from 0-100!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Sorry, that was not a valid input. Please try again!");
            }
        } while (attempts > 0);
    }
}