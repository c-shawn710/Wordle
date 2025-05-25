package sc.wordle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WordManager wordManager = new WordManager();
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;
        while (playAgain) {
            String secretWord = wordManager.selectRandomWord();

            //Create and start the game
            WordleGame game = new WordleGame(scanner, secretWord);
            game.start();

            while (true) {
                System.out.println("Play again? (Y / N)");
                String response = scanner.nextLine();

                if (response.equalsIgnoreCase("Y")) {
                    playAgain = true;
                    break;
                } else if (response.equalsIgnoreCase("N")) {
                    playAgain = false;
                    break;
                } else {
                    System.out.println("Invalid input.");
                }
            }

            //playAgain = response.equalsIgnoreCase("Y");
        }
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
