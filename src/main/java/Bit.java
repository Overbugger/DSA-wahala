import java.util.Scanner;

public class Bit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        int X = 0;

        for (int i = 0; i < n; i++) {
            String statement = scanner.nextLine();
            if (statement.contains("++")) {
                X++;
            } else {
                X--;
            }
        }

        System.out.println(X);
        scanner.close();
    }
}
