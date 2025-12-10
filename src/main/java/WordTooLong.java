import java.util.Scanner;

public class WordTooLong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String word = scanner.next();
            System.out.println(wordTooLong(word));
        }

        scanner.close();

    }

    private static String wordTooLong(String word) {
        var wordLength = word.length();
        if (wordLength <= 10) {
            return word;
        }

        return word.charAt(0) + String.valueOf(wordLength - 2) + word.charAt(wordLength - 1);

    }
}
