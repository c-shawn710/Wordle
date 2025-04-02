package sc.wordle;

public class GuessEvaluator {
    /**
     * Compares the {@code guess} to the {@code secretWord}.
     * <p>
     * Correct letter and position -> UPPERCASE.
     * Correct letter but wrong position -> lowercase.
     * Incorrect letter -> [letter].
     *
     * @param guess The player's guessed word.
     * @param secretWord The actual word to guess.
     * @return A formatted string showing feedback for each letter.
     * */
    public String evaluateGuess(String guess, String secretWord) {
        StringBuilder feedback = new StringBuilder();

        for (int i = 0; i < guess.length(); i++) {  //For each loop is to loop through each letter in the 'guess'
            char guessedChar = guess.charAt(i);
            char actualChar = secretWord.charAt(i);

            if (guessedChar == actualChar) {
                feedback.append(Character.toUpperCase(guessedChar)).append(" ");    //Character is a utility class for working with char values. Can use it to "check if digit", "check if letter", "check if lower/uppercase", and in our case, we use it to make our characters upper/lowercase
            } else if (secretWord.contains(String.valueOf(guessedChar))) { //contains() is part of the String class. But guessedChar is a char, so we use String.valueOf to convert it into a String.
                feedback.append(Character.toLowerCase(guessedChar)).append(" ");
            } else {
                feedback.append("[").append(guessedChar).append("] ");
            }
        }
        return feedback.toString(); //Turn StringBuilder back to a String
    }
}
