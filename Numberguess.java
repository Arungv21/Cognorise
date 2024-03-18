import java.util.Scanner;
import java.util.Random;
public class Numberguess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100
        int randomNumber = random.nextInt(100) + 1;

        int attempts = 0;
        final int MAX_ATTEMPTS = 5;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("I've chosen a number between 1 and 100. Try to guess it.");

        // Start the game loop
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == randomNumber) {
                System.out.println("Congratulations! You've guessed the number.");
                System.out.println("It took you " + attempts + " attempts.");
                break;
            } else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        // If the player couldn't guess within the attempts limit
        if (attempts == MAX_ATTEMPTS) {
            System.out.println("Sorry, you've reached the maximum number of attempts.");
            System.out.println("The number I had in mind was: " + randomNumber);
        }

        scanner.close();
    }
}
