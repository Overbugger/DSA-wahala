import java.util.Scanner;

public class StringLexicality {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();

        System.out.println(compare(string1, string2));

        scanner.close();

    }

    private static int compare(String string1, String string2) {
        int result = string2.compareToIgnoreCase(string1);

        if(result < 0){
            return 1;
        } else if (result > 0) {
            return -1;
        }
        return 0;
    }
}
