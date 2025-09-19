package DSA.graph;

import DSA.utils.DisjointSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Most Stones Removed With Same Row Or Column
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/">LeetCode</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Graph, Disjoint Set Union (DSU)</li>
 * </ul>
 *
 * <p>Approach:
 * <ol>
 *   <li>Model the problem as a graph where each stone connects its row and column.</li>
 *   <li>Use Disjoint Set Union (DSU) to group stones connected by rows or columns.</li>
 *   <li>The number of stones that can be removed is the total stones minus the number of connected components.</li>
 * </ol>
 * </p>
 *
 * <p>Time Complexity: O(N * α(N)) where N is the number of stones and α is the inverse Ackermann function.</p>
 * <p>Space Complexity: O(R + C) where R is max row index and C is max column index.</p>
 */
public class __G53__MostStonesRemovedWithSameRowOrColumn {

    /**
     * Removes the maximum number of stones such that each remaining stone shares
     * a row or column with another stone.
     *
     * @param stones 2D array where stones[i] = [row, column] represents the position of the ith stone
     * @return Maximum number of stones that can be removed
     */
    public int removeStones(int[][] stones) {
        // Find max row and column indices
        int maxRow = 0, maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        // Initialize DSU for all rows and columns
        DisjointSet dsu = new DisjointSet(maxRow + 1 + maxCol + 1);

        // Connect stones by row and column
        for (int[] stone : stones) {
            dsu.unionBySize(stone[0], (maxRow + 1) + stone[1]);
        }

        // Count number of unique connected components
        Set<Integer> uniqueRoots = new HashSet<>();
        for (int[] stone : stones) {
            uniqueRoots.add(dsu.find(stone[0]));
        }

        // Maximum removable stones = total stones - number of components
        return stones.length - uniqueRoots.size();
    }
}
