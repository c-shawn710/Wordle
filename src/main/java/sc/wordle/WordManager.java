package sc.wordle;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class WordManager {
    private List<String> words; //Stores the list of words

    /**
     * Constructs a {@code WordManager} object.
     * <p>
     * Attempts to read all words from the "words.txt" file
     * and stores them in the {@code words} list.
     * <p>
     * If the "words.txt" is missing or empty, it falls back to a default word list.
     */
    public WordManager() {
        try {
            words = Files.readAllLines(Paths.get("words.txt"));
            if (words.isEmpty()) {
                throw new Exception("Word list is empty!");
            }
        } catch (Exception e) {
            System.out.println("Error reading from file: " + e.getMessage());
            words = List.of("apple", "chair", "world", "plate", "stone"); //Fallback words
        }
    }

    /**
     * Selects a random word from the list.
     * <p>
     * Uses the {@code Random} class to generate a random index within the
     * bounds of the {@code words} list.
     *
     * @return The word corresponding with the randomly selected index
     * from the list.
     */
    public String selectRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
