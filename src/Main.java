import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> dictionaryHashMap = DictionaryManager.getDictionary();

        System.out.println("\t1 2 3 \n 12      4\n 11      5\n 10      6\n\t9 8 7");

        // Array of letters
        Letter[] letters = getLetters(scanner);

        // Map for used/unused letters
        HashMap<String, Boolean> usedLetters = new HashMap<>();
        for (Letter letter : letters) {
            usedLetters.put(letter.getLetter(), false);
        }

        // Make list of possible words
        List<String> possibleWords = fillPossibleWords(letters);

    }

    private static Letter[] getLetters(Scanner scanner) {
        String[] letters;
        do {
            System.out.println("Input the 12 letters in this order, separated by spaces:");
            System.out.print("Letters: ");
            letters = scanner.nextLine().strip().split(" ");
        } while (letters.length != 12 || Arrays.stream(letters).anyMatch(s -> s.length() != 1));

        Letter[] lettersArray = new Letter[letters.length];
        for (int i = 0; i < letters.length; i++) {
            lettersArray[i] = new Letter(letters[i], i / 3);
        }
        return lettersArray;
    }

    private static List<String> fillPossibleWords(Letter[] letters) {
        int shortestWordLength = 3, longestWordLength = 12;
        List<String> possibleWords = new ArrayList<>();
        for (Letter letter : letters) {
            String currentWord = letter.getLetter();
        }

        return possibleWords;
    }
}