package DSA.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Minimum Window Substring
 * <ul>
 *     <li>Link: <a href="https://leetcode.com/problems/minimum-window-substring/description/">
 *         Minimum Window Substring</a></li>
 *     <li>Difficulty: Hard</li>
 *     <li>Tags: Sliding Window, Two Pointers, String</li>
 * </ul>
 *
 * <p><b>Approach (HashMap Version):</b></p>
 * <ul>
 * <li>Build a frequency map for characters in string {@code t}.</li>
 * <li>Use a sliding window over {@code s} while maintaining a frequency map for window characters.</li>
 * <li>Track how many required characters are currently satisfied using a {@code formed} counter.  </li>
 * <li>Expand the window to the right until all required characters are present, then shrink from the left
 * to find the smallest valid window.  </li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(|s| + |t|)
 * <br><b>Space Complexity:</b> O(|t|) for frequency maps.</p>
 *
 * <p><b>Optimized Approach (Array Version):</b></p>
 * <p>
 * Replace HashMaps with fixed-size ASCII arrays of length 128.
 * This reduces hashing overhead and improves performance.
 * Logic remains identical to the HashMap solution but with constant-time array indexing.
 * </p>
 *
 * <p><b>Optimized Time Complexity:</b> O(|s| + |t|)
 * <br><b>Optimized Space Complexity:</b> O(1) — fixed array size (128).</p>
 */

public class __SW12__MinimumWindowSubstring {

    /**
     *
     * HashMap version
     *
     */

    public String minWindow(String s, String t) {
        Map<Character, Integer> freqS = new HashMap<>();
        Map<Character, Integer> freqT = new HashMap<>();

        for (char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }

        int required = freqT.size();
        int formed = 0;

        int left = 0, ansL = 0, ansR = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freqS.put(c, freqS.getOrDefault(c, 0) + 1);

            if (freqT.containsKey(c) && freqS.get(c).intValue() == freqT.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    ansL = left;
                    ansR = right;
                }
                char leftChar = s.charAt(left);
                freqS.put(leftChar, freqS.get(leftChar) - 1);

                if (freqT.containsKey(leftChar) && freqS.get(leftChar) < freqT.get(leftChar)) {
                    formed--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR + 1);
    }


    /**
     *
     * Array Version
     *
     */
    public String minWindowOptimized(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return "";

        int[] freqT = new int[128];   // frequency of required characters
        int[] freqS = new int[128];   // frequency inside current window

        int required = 0;

        // Build freqT and count how many distinct characters are needed
        for (char c : t.toCharArray()) {
            if (freqT[c] == 0) required++;   // count unique chars
            freqT[c]++;
        }

        int formed = 0;
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        int ansL = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            freqS[c]++;

            // If this char meets the required frequency
            if (freqT[c] != 0 && freqS[c] == freqT[c]) {
                formed++;
            }

            // When window is valid, shrink from left
            while (l <= r && formed == required) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    ansL = l;
                }

                char left = s.charAt(l);
                freqS[left]--;

                if (freqT[left] != 0 && freqS[left] < freqT[left]) {
                    formed--;
                }

                l++;
            }

            r++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(ansL, ansL + minLen);
    }
}
