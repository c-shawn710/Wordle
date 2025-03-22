package sc.wordle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WordManager wordManager = new WordManager();
        GuessEvaluator guessEvaluator = new GuessEvaluator();
        Scanner scanner = new Scanner(System.in);
        String secretWord = wordManager.selectRandomWord();

        //Create and start the game
        WordleGame game = new WordleGame(wordManager, guessEvaluator, scanner, secretWord);
        game.start();
        scanner.close();
    }
}
