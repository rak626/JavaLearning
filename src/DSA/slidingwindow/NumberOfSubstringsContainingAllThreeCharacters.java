package DSA.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Number Of Substrings Containing All Three Characters
 * Link: <a href="https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/">...</a>
 * Difficulty: Medium
 * Tags: SlidingWindow
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0, right = 0, cnt = 0;
        Map<Character, Integer> cntMap = new HashMap<>();

        for (; right < n; right++) {
            cntMap.merge(s.charAt(right), 1, Integer::sum);
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
