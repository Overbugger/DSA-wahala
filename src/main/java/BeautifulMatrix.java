import java.util.Scanner;

public class BeautifulMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = 0;
        int column = 0;

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                int value = scanner.nextInt();
                if (value == 1) {
                    row = i;
                    column = j;
                }
            }
        }

        // Calculate Manhattan distance to center (3, 3)
        // Manhattan distance (or taxicab distance/L1 norm) is the distance between two points in a grid-like path, calculated by summing the absolute differences of their coordinates, like a taxi navigating city blocks instead of cutting through buildings. For points (x1,y1) and (x2,y2), the formula is |x1-x2|+|y1-y2|.
        int moves = Math.abs(row - 3) + Math.abs(column - 3);

        System.out.println(moves);

        scanner.close();
    }

}
