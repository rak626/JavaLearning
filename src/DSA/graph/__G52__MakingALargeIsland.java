package DSA.graph;

import DSA.utils.DisjointSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Making A Large Island
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/making-a-large-island/description/">Making A Large Island</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: graph, dsu, union-find</li>
 * </ul>
 *
 * <p>Approach:</p>
 * <ol>
 *   <li>Use a Disjoint Set Union (DSU) to group adjacent 1's into islands.</li>
 *   <li>Flatten the 2D grid to 1D indices: node = r * n + c.</li>
 *   <li>First pass: union all adjacent 1's to form connected components (islands).</li>
 *   <li>Keep track if there is any 0 in the grid. If none, the largest island is n*n.</li>
 *   <li>Second pass: for each 0, check all 4 neighbors:
 *       <ul>
 *           <li>Add the sizes of all unique neighboring islands.</li>
 *           <li>Consider flipping this 0 to 1 to get a larger island.</li>
 *       </ul>
 *   </li>
 *   <li>Return the maximum island size obtained.</li>
 * </ol>
 *
 * <p>Time Complexity: O(n^2 * α(n^2)), where α is the inverse Ackermann function.</p>
 * <p>Space Complexity: O(n^2) for DSU arrays and sets.</p>
 */
public class __G52__MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet dsu = new DisjointSet(n * n);
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean hasZero = false;

        // Step 1: Build islands by union adjacent 1's
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int node = r * n + c;
                    for (int[] dir : directions) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            dsu.unionBySize(node, nr * n + nc);
                        }
                    }
                } else {
                    hasZero = true;
                }
            }
        }

        // If no zero exists, grid is already full of 1's
        if (!hasZero) return n * n;

        int best = 0;

        // Step 2: Try flipping each zero
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> neighborRoots = new HashSet<>();
                    for (int[] dir : directions) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            neighborRoots.add(dsu.find(nr * n + nc));
                        }
                    }

                    int totalSize = 1; // flipped cell
                    for (int root : neighborRoots) {
                        totalSize += dsu.getSize(root);
                    }

                    best = Math.max(best, totalSize);
                }
            }
        }

        // Return the maximum size (in case grid is all 1's, max island is the largest DSU component)
        int maxIsland = 0;
        for (int i = 0; i < n * n; i++) {
            maxIsland = Math.max(maxIsland, dsu.getSize(i));
        }

        return Math.max(best, maxIsland);
    }
}
