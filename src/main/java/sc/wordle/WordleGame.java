package sc.wordle;

import java.util.Scanner;

public class WordleGame {
    private WordManager wordManager;
    private GuessEvaluator guessEvaluator;
    private Scanner scanner;
    private String secretWord;
    private final int maxAttempts = 5;

    public WordleGame(WordManager wordManager, GuessEvaluator guessEvaluator, Scanner scanner, String secretWord) {
        this.wordManager = wordManager;
        this.guessEvaluator = guessEvaluator;
        this.scanner = scanner;
        this.secretWord = secretWord;
    }

    public void start() {
        System.out.println("Guess the 5-letter word in " + maxAttempts + " attempts.\n");
        System.out.println("""
                UPPERCASE -> Correct letter in the correct position.
                lowercase -> Correct letter in the incorrect position.
                [letter]  -> Incorrect letter.
                """);

        int attempts = 1;
        while (attempts <= maxAttempts) {
            System.out.println("Enter guess #" + (attempts) + ": ");
            String guess = scanner.nextLine().toLowerCase();

            //Input validation
            if (guess.length() != 5 || !guess.matches("[a-zA-z]+")) {
                System.out.println("Invalid input. Please enter a 5-letter word.\n");
                continue; //Skip the rest of the loop, don't increment attempts
            }

            //Evaluate the guess
            String feedback = guessEvaluator.evaluateGuess(guess, secretWord);
            System.out.println("Feedback: " + feedback + "\n");

            //Check for win
            if (guess.equalsIgnoreCase(secretWord)) {
                System.out.println("You guessed the correct word in " + (attempts) + "attempt(s)!");
                return;
            }
            attempts++;
        }

        //All attempts used
        System.out.println("No more attempts. Your word was: " + secretWord);
    }
}
