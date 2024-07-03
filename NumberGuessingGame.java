import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain = true;
        int roundNumber = 1;
        int totalScore = 0;

        while (playAgain) {
            System.out.println("\nRound " + roundNumber);
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean roundWon = false;

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ". Enter your guess (1-100): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    roundWon = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!roundWon) {
                System.out.println("Sorry! You've used all attempts. The correct number was " + numberToGuess + ".");
            }

            totalScore += roundWon ? 1 : 0;
            System.out.println("Your score after round " + roundNumber + ": " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");

            roundNumber++;
        }

        System.out.println("Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
