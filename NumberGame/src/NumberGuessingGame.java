/*
Poovarasan H
Java Programming Intern
*/
package NumberGame.src;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int rounds_played = 0;
        boolean play_again = true;

        // Game loop for multiple rounds
        while (play_again) {

            // Generate random number between 1 and 100
            int numberToGuess = random.nextInt(100) + 1;

            // Limiting attempts to 10
            int attempts = 10;

            boolean hasGuessedCorrectly = false;
            rounds_played++;

            System.out.println("Round " + rounds_played + ": Guess the number between 1 and 100. You have " + attempts + " attempts.");

            // Attempt loop for each round
            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();

                // Compare user's guess with the generated number
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number.");

                    // Higher score for fewer attempts
                    score += (attempts * 10);

                    // Display the current score
                    System.out.println("Your score for this round: " + (attempts * 10));
                    System.out.println("Total score: " + score);

                    hasGuessedCorrectly = true;
                    break;

                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }
                System.out.println("-----------------");

                attempts--;
                System.out.println("Attempts remaining: " + attempts);
            }

            // If user fails to guess the number within the allowed attempts
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess);
            }

            // Ask the player if they want to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = sc.next();
            play_again = response.equalsIgnoreCase("yes");
        }

        // Display final score and rounds played
        System.out.println("Game Over! You played " + rounds_played + " rounds.");
        System.out.println("Your final score is: " + score);

        sc.close();
    }
}
