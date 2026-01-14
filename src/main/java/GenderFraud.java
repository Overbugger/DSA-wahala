import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GenderFraud {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        int numberOfDistinctChars = countDistinctChars(username);

        if (numberOfDistinctChars % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }

        scanner.close();
    }

    private static int countDistinctChars(String str) {

        Set<Character> distinctChars = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            distinctChars.add(str.charAt(i));
        }

        return distinctChars.size();

    }
}
