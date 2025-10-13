package DSA.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Number Of Substrings Containing All Three Characters
 * <ul>
 *   <li>LeetCode: <a href="https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/">
 *       Number Of Substrings Containing All Three Characters</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Sliding Window, HashMap, String</li>
 * </ul>
 *
 * <p><b>Problem Summary:</b></p>
 * <p>
 * Given a string <code>s</code> containing only 'a', 'b', and 'c',
 * return the number of substrings that contain at least one occurrence of all three characters.
 * </p>
 *
 * <h2>Approach / Intuition:</h2>
 * <ul>
 *   <li>Sliding Window + HashMap:
 *     <ol>
 *       <li>Use two pointers <code>left</code> and <code>right</code> to maintain a window.</li>
 *       <li>Use a map to track the count of 'a', 'b', and 'c' in the current window.</li>
 *       <li>If the window contains all three characters → all substrings starting at <code>left</code> and ending ≥ <code>right</code> are valid.</li>
 *       <li>Increment <code>cnt</code> by <code>n - right</code> and shrink the window from <code>left</code> until it no longer contains all three.</li>
 *     </ol>
 *   </li>
 * </ul>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time:</b> O(n) → each character enters/exits the window at most once</li>
 *   <li><b>Space:</b> O(1) → fixed size map for 3 characters</li>
 * </ul>
 */
public class __SW7__NumberOfSubstringsContainingAllThreeCharacters {

    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0, right = 0, cnt = 0;
        Map<Character, Integer> cntMap = new HashMap<>();

        for (; right < n; right++) {
            cntMap.merge(s.charAt(right), 1, Integer::sum);

            // shrink window if all three characters are present
            while (cntMap.size() == 3) {
                cnt += n - right;
                if (cntMap.merge(s.charAt(left), -1, Integer::sum) == 0) {
                    cntMap.remove(s.charAt(left));
                }
                left++;
            }
        }

        return cnt;
    }
}
