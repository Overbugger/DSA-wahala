import com.endpoint.DS.Containers.Stack;

import java.util.Scanner;

public class BalancedParenthesis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.println("Enter a string with parentheses:");
        String statement = scanner.nextLine();

        boolean isBalanced = checkBalanced(statement, stack);

        if (isBalanced) {
            System.out.println("The parentheses are balanced.");
        } else {
            System.out.println("The parentheses are NOT balanced.");
        }

        scanner.close();
    }

    public static boolean checkBalanced(String statement, Stack<Character> stack) {
        for(int i = 0; i < statement.length(); i++) {
            char ch = statement.charAt(i);

            // Push opening brackets onto the stack
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }

            // Check closing brackets
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false; // No matching opening bracket
                }

                char top = stack.pop();

                // Check if the brackets match
                if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets were matched
        return stack.isEmpty();
    }

}
