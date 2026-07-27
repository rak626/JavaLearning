package DSA.graph;

import java.util.*;

/**
 * Problem: Word Ladder
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/word-ladder/description/">Word Ladder</a></li>
 *   <li>Difficulty: Hard</li>
 *   <li>Tags: Graph, BFS</li>
 * </ul>
 * <p>
 * Description:
 * Given __2__ words (beginWord and endWord) and a dictionary wordList,
 * return the length of the shortest transformation sequence from beginWord
 * to endWord, where:
 * <ul>
 *   <li>Only __1__ letter can be changed at a time.</li>
 *   <li>Each transformed word must exist in the wordList.</li>
 * </ul>
 * If no such sequence exists, return 0.
 * <p>
 * Approach:
 * - Use BFS (level-order traversal) starting from beginWord.
 * - For each word, generate all possible __1__-character transformations.
 * - If a transformed word exists in the dictionary, enqueue it and remove from the set (to avoid revisits).
 * - Stop when endWord is reached and return the step count.
 * - If BFS finishes without finding endWord, return 0.
 * <p>
 * Time: O(N * M * 26) where N = number of words, M = word length
 * Space: O(N) for the word set and BFS queue
 */
public class __G29__WordLadder {

    /**
     * Computes the shortest transformation sequence from beginWord to endWord.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        // Quick exit if the target isn't reachable
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        var queue = new ArrayDeque<String>();
        queue.offer(beginWord);
        wordSet.remove(beginWord); // Mark as visited

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all nodes at the current level
            for (int k = 0; k < size; k++) {
                String currentWord = queue.poll();

                if (endWord.equals(currentWord)) {
                    return level;
                }

                char[] chars = currentWord.toCharArray();

                // Mutate each character to find single-edit neighbors
                for (int i = 0; i < chars.length; i++) {
                    char originalChar = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;

                        chars[i] = c;
                        String nextWord = new String(chars);

                        if (wordSet.contains(nextWord)) {
                            queue.offer(nextWord);
                            wordSet.remove(nextWord); // Mark as visited
                        }
                    }

                    chars[i] = originalChar; // Reset character
                }
            }

            level++;
        }

        return 0;
    }
}
