import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> dictionaryHashMap = DictionaryManager.getDictionary();

        System.out.println("\t1 2 3 \n 12      4\n 11      5\n 10      6\n\t9 8 7");
        String[] letters = new String[12];
        do {
            System.out.println("Input the 12 letters in this order, separated by spaces:");
            System.out.print("Letters: ");
            letters = scanner.nextLine().strip().split(" ");
        } while (letters.length != 12 || Arrays.stream(letters).anyMatch(s -> s.length() != 1));


        LetterBox letterBox = new LetterBox(letters);
    }

}