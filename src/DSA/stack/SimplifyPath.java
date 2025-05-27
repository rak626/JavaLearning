package DSA.stack;

import java.util.Stack;

/**
 * Problem: Simplify Path
 * Link: <a href="https://leetcode.com/problems/simplify-path/description/">Click here</a>
 * Difficulty: Medium
 * Tags: stack
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] words = path.split("/");
        Stack<String> st = new Stack<>();
        for (String word : words) {
            if (word.isBlank() || word.equals(".")) continue;
            if (word.equals("..")) {
                if (!st.isEmpty()) st.pop();
            } else {
                st.push(word);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, "/" + st.pop());
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
}
