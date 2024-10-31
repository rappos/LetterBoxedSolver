import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> dictionaryHashMap = DictionaryManager.getDictionary();

        // Array of letters
        String[] letters = getLetters(scanner);

        // Filter dictionary according to the rules
        filterDictionary(letters, dictionaryHashMap);


        // Make a list of allowed words
        ArrayList<String> allowedWords = new ArrayList<>(dictionaryHashMap.keySet());

        // Ask about max number of words
        System.out.print("Max number of words: ");
        int maxWords = scanner.nextInt();
        ArrayList<ArrayList<String>> solutions = new ArrayList<>();
        // Add all words once
        ArrayList<String> innerList;
        for (String word : allowedWords) {
            innerList = new ArrayList<>();
            innerList.add(word);
            solutions.add(innerList);
        }

    }

    private static void filterDictionary(String[] letters, HashMap<String, Integer> dictionaryHashMap) {
        // Make unallowed letter combos
        ArrayList<String> unallowedCombinations = getUnallowedCombos(letters);

        //Filter out words with any letter that aren't in the letters array
        dictionaryHashMap.keySet()
                .removeIf(word -> Arrays.stream(word.split(""))
                        .anyMatch(letter -> !Arrays.asList(letters).contains(letter)));

        // Filter out words shorter than 3 letters
        dictionaryHashMap.keySet()
                .removeIf(word -> word.length() < 3);

        //Filter out words if it contains any of the unallowed letter combos
        dictionaryHashMap.keySet().removeIf(key -> {
            for (String unallowedCombo : unallowedCombinations) {
                if (key.contains(unallowedCombo)) {
                    return true;
                }
            }
            return false;
        });
    }

    private static ArrayList<String> getUnallowedCombos(String[] letters) {
        ArrayList<String> unallowedCombinations = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int j = i * 3;
            for (int k = 0; k < 3; k++) {
                unallowedCombinations.add(letters[j + k] + letters[j]);
                unallowedCombinations.add(letters[j + k] + letters[j + 1]);
                unallowedCombinations.add(letters[j + k] + letters[j + 2]);
            }
        }
        return unallowedCombinations;
    }

    private static String[] getLetters(Scanner scanner) {
        String[] letters;
        do {
            System.out.println("Input the 12 letters of the puzzle:");
            System.out.print("Letters: ");
            letters = scanner.nextLine().strip().split("");
        } while (letters.length != 12 || Arrays.stream(letters).anyMatch(s -> s.length() != 1));
        return letters;
    }


}