import java.util.Scanner;

public class Team {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        int solveCount = 0;

        for (int i = 0; i < n; i++) {
            String numb = scanner.nextLine();
            if (canSolve(numb)) {
                solveCount++;
            }
        }

        System.out.println(solveCount);
        scanner.close();
    }

    private static boolean canSolve(String input) {
        String[] inputStrArr = input.trim().split(" ");
        if (inputStrArr.length < 3) {
            return false;
        }

        int count = 0;

        for (int i = 0; i < inputStrArr.length; i++) {
            int value = Integer.parseInt(inputStrArr[i]);

            if (value != 0 && value != 1) {
                return false;
            }

            if (value == 1) {
                count++;
            }
        }

        return count >= 2;
    }
}
