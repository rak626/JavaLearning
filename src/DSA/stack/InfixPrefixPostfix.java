package DSA.stack;

import java.util.Stack;

/**
 * Problem: InfixPrefixPostfix
 * Link: <a href="https://www.geeksforgeeks.org/convert-infix-expression-to-postfix-expression/">Click here</a>
 * Difficulty: Easy
 * Tags: Stack
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class InfixPrefixPostfix {
    public static String infixToPostfix(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop(); // Remove the '(' from the stack
                }
            } else {
                while (!st.isEmpty() && st.peek() != '(' && priority(c) <= priority(st.peek())) {
                    sb.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }

    public static int priority(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        String s = "2+3*20/2^2";
        System.out.println(infixToPostfix(s));
    }

}
