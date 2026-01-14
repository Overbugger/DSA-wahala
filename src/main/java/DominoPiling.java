import java.util.Scanner;

public class DominoPiling {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int x = scanner.nextInt();
         int y = scanner.nextInt();

         int area = x * y;

         System.out.println(area/2);

         scanner.close();
     }

}
