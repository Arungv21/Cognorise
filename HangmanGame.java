import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    public static void main(String[] args) {
        String[] words = {"java", "programming", "computer", "hangman", "keyboard", "algorithm"}; // List of words
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String wordToGuess = words[random.nextInt(words.length)]; // Select a random word
        int wordLength = wordToGuess.length();
        char[] displayWord = new char[wordLength]; // Displayed word with blanks
        for (int i = 0; i < wordLength; i++) {
            displayWord[i] = '_';
        }

        int maxAttempts = 6; // Maximum number of incorrect guesses
        int incorrectGuesses = 0;

        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the word: " + new String(displayWord));

        // Game loop
        while (incorrectGuesses < maxAttempts) {
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);

            boolean correctGuess = false;
            for (int i = 0; i < wordLength; i++) {
                if (wordToGuess.charAt(i) == guess) {
                    displayWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                incorrectGuesses++;
                System.out.println("Incorrect guess! Attempts left: " + (maxAttempts - incorrectGuesses));
                displayHangman(incorrectGuesses);
            }

            System.out.println("Word: " + new String(displayWord));

            // Check if the word has been guessed
            if (new String(displayWord).equals(wordToGuess)) {
                System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                break;
            }
        }

        if (incorrectGuesses == maxAttempts) {
            System.out.println("Sorry, you ran out of attempts. The word was: " + wordToGuess);
        }

        scanner.close();
    }

    // Method to display hangman figure based on incorrect guesses
    public static void displayHangman(int incorrectGuesses) {
        String[] hangmanFigures = {
                "  +---+\n" +
                "  |   |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "=========",
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "=========",
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                "  |   |\n" +
                "      |\n" +
                "      |\n" +
                "=========",
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|   |\n" +
                "      |\n" +
                "      |\n" +
                "=========",
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                "      |\n" +
                "      |\n" +
                "=========",
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                " /    |\n" +
                "      |\n" +
                "=========",
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                " / \\  |\n" +
                "      |\n" +
                "========="
        };

        System.out.println(hangmanFigures[incorrectGuesses - 1]);
    }
}
