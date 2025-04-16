package DSA.slidingwindow;

import java.util.Arrays;

/**
 * Problem: Longest Substring Without Repeating Characters
 * Link: <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/">...</a>
 * Difficulty: Medium
 * Tags: SlidingWindow
 * <p>
 * Approach:
 * 1. create a hash for 255 chars in ascii
 * 2.
 * -
 * <p>
 * Time: O(2N)
 * Space: O(1)
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
		if (n == 0) return 0;
		int[] lastSeen = new int[256];
        Arrays.fill(lastSeen, -1);

		int maxLength = 0;
		int start = 0;

		for (int end = 0; end < n; end++) {
			char currentChar = s.charAt(end);
			if (lastSeen[currentChar] >= start) {
				start = lastSeen[currentChar] + 1;
			}
			lastSeen[currentChar] = end;
			maxLength = Math.max(maxLength, end - start + 1);
		}

		return maxLength;
    }
}
