package DSA.stack;

import java.util.Stack;

/**
 * Problem: Valid Parentheses
 * Link: <a href="https://leetcode.com/problems/valid-parentheses/description/">Click here</a>
 * Difficulty: Easy
 * Tags: Stack
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O(n)
 * Space: O(n)
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == ')' || c == '}' || c == ']') {
                if (st.isEmpty()) {
                    return false;
                }
                Character peeked = st.peek();
                if (!((c == ')' && peeked == '(') || (c == '}' && peeked == '{') || (c == ']' && peeked == '['))) {
                    return false;
                }
                st.pop();
            } else {
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
