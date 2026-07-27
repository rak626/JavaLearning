package DSA.graph;

import java.util.*;

/**
 * Problem: Word Ladder II
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/word-ladder-ii/description/">Word Ladder II</a></li>
 *   <li>Difficulty: Hard</li>
 *   <li>Tags: Graph, BFS, Backtracking</li>
 * </ul>
 * <p>
 * Description:
 * Given __2__ words (beginWord and endWord) and a dictionary wordList,
 * return all the shortest transformation sequences from beginWord to endWord.
 * Each transformation changes exactly __1__ letter and must exist in the wordList.
 * If there is no such sequence, return an empty list.
 */
public class __G30__WordLadderII {

    // --------------------------------------------------------
    // 1️. Optimized BFS + DFS Approach
    // --------------------------------------------------------

    /**
     * Optimized Approach:
     * - BFS builds the graph of valid "next word" connections for shortest paths only.
     * - DFS backtracks through this graph to collect all possible shortest sequences.
     * <p>
     * Time: O(N * M * 26 + P * L)
     * Space: O(N * M)
     * where
     * <ul>
     *     <li>N = number of words</li>
     *     <li>M = word length</li>
     *     <li>P = number of shortest paths</li>
     *     <li>L = path length</li>
     * </ul>
     */
    public List<List<String>> findLaddersOptimized(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);

        // Early check: if endWord is not in the dictionary, no sequence exists
        if (!wordSet.contains(endWord)) {
            return results;
        }

        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();

        // Phase 1: BFS to build the shortest-path graph and distance map
        bfs(beginWord, endWord, wordSet, adj, dist);

        // If endWord was never reached during BFS, return empty list
        if (!dist.containsKey(endWord)) {
            return results;
        }

        // Phase 2: DFS to collect all shortest path sequences
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, adj, dist, path, results);

        return results;
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet,
                     Map<String, List<String>> adj, Map<String, Integer> dist) {

        for (String word : wordSet) {
            adj.put(word, new ArrayList<>());
        }
        adj.putIfAbsent(beginWord, new ArrayList<>());

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        dist.put(beginWord, 0);

        boolean foundEnd = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();
                int currentDist = dist.get(currentWord);

                for (String nextWord : getNeighbors(currentWord, wordSet)) {

                    // Case 1: First time discovering 'nextWord'
                    if (!dist.containsKey(nextWord)) {
                        dist.put(nextWord, currentDist + 1);
                        adj.get(currentWord).add(nextWord);
                        queue.offer(nextWord);

                        if (nextWord.equals(endWord)) {
                            foundEnd = true;
                        }
                    }
                    // Case 2: 'nextWord' was discovered by another parent at the SAME level
                    else if (dist.get(nextWord) == currentDist + 1) {
                        adj.get(currentWord).add(nextWord);
                    }
                }
            }

            // Stop BFS once the current level finishes after finding endWord
            if (foundEnd) break;
        }
    }

    private void dfs(String currentWord, String endWord, Map<String, List<String>> adj,
                     Map<String, Integer> dist, List<String> path, List<List<String>> results) {

        // Base Case: Target reached -> add snapshot of current path
        if (currentWord.equals(endWord)) {
            results.add(new ArrayList<>(path));
            return;
        }

        if (!adj.containsKey(currentWord)) return;

        for (String nextWord : adj.get(currentWord)) {
            // Strictly follow the shortest path tree (+1 level step)
            if (dist.containsKey(nextWord) && dist.get(nextWord) == dist.get(currentWord) + 1) {
                path.add(nextWord);                                     // Choose
                dfs(nextWord, endWord, adj, dist, path, results);      // Recurse
                path.removeLast();                          // Backtrack
            }
        }
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;

                chars[i] = c;
                String mutatedWord = new String(chars);

                if (wordSet.contains(mutatedWord)) {
                    neighbors.add(mutatedWord);
                }
            }

            chars[i] = originalChar; // Reset back
        }

        return neighbors;
    }

    // --------------------------------------------------------
    // 2️⃣ BFS-only Approach (No DFS)
    // --------------------------------------------------------

    /**
     * BFS-only Approach:
     * - Each queue element is a full path.
     * - Once endWord is found at a level, stop and collect all paths of that level.
     * <p>
     * Time: O(N * M * 26 * P) in worst case
     * Space: O(N * P * L)
     * where P = number of shortest paths, L = path length
     */
    public List<List<String>> findLaddersBFSOnly(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> results = new ArrayList<>();
        if (!dict.contains(endWord)) return results;

        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(Collections.singletonList(beginWord));

        Set<String> visited = new HashSet<>();
        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> levelVisited = new HashSet<>(); // words visited at this BFS level

            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                String lastWord = path.get(path.size() - 1);

                if (lastWord.equals(endWord)) {
                    results.add(new ArrayList<>(path));
                    found = true; // collect only shortest paths
                }

                char[] chars = lastWord.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char old = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == old) continue;
                        chars[j] = ch;
                        String nextWord = new String(chars);

                        // Only consider words from dict not yet used in previous levels
                        if (dict.contains(nextWord) && !visited.contains(nextWord)) {
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(nextWord);
                            queue.offer(newPath);       // extend path
                            levelVisited.add(nextWord); // mark for this level
                        }
                    }
                    chars[j] = old; // restore
                }
            }

            // Mark words as visited after the whole level is processed
            visited.addAll(levelVisited);
        }
        return results;
    }
}
