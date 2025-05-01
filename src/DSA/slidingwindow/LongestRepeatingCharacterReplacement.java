package DSA.slidingwindow;

/**
 * Problem: Longest Repeating Character Replacement
 * Link: <a href="https://leetcode.com/problems/longest-repeating-character-replacement/description/">...</a>
 * Difficulty: Medium
 * Tags: SlidingWindow
 * <p>
 * Approach:
 * - 1. Normal Sliding window technique applied.
 * -
 * <p>
 * Time: O(N)
 * Space: O(26) ~ O(1)
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0, maxLen = 0, maxFreq = 0;
        int[] hash = new int[26];
        for (int right = 0; right < n; right++) {
            int idx = s.charAt(right) - 'A';
            hash[idx]++;
            maxFreq = Math.max(maxFreq, hash[idx]);
            if ((right - left + 1) - maxFreq > k) { //
                int leftIdx = s.charAt(left) - 'A';
                hash[leftIdx]--;
                left++;
//                maxFreq = Arrays.stream(hash).max().getAsInt();
//                remove this line because if maxFreq will not bigger, then maxLen will not be bigger. So no point to be updating maxFreq
             }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
