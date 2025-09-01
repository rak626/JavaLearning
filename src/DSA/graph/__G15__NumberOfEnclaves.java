package DSA.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: Number Of Enclaves
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/number-of-enclaves/description/">Number Of Enclaves</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Graph, BFS, Matrix</li>
 * </ul>
 *
 * <p>
 * Approach:
 * <ul>
 *   <li>Any land cell (1) connected to the boundary cannot be an enclave.</li>
 *   <li>Perform BFS from all boundary land cells to mark them as visited.</li>
 *   <li>Finally, count all unvisited land cells; these are the enclaves.</li>
 * </ul>
 *
 * <p>
 * Time Complexity: O(m * n), where m = rows, n = cols (each cell visited at most once)<br>
 * Space Complexity: O(m * n) for visited array + BFS queue
 */
public class __G15__NumberOfEnclaves {

    private boolean[][] vis;
    private int rows, cols;
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * Counts the number of enclave cells in the grid.
     * An enclave is a land cell (1) that cannot reach the boundary.
     *
     * @param grid 2D grid of 0s (water) and 1s (land)
     * @return number of enclave land cells
     */
    public int numEnclaves(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        rows = grid.length;
        cols = grid[0].length;
        vis = new boolean[rows][cols];

        // Step 1: BFS from all boundary land cells
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1 && !vis[i][0]) bfs(i, 0, grid);
            if (grid[i][cols - 1] == 1 && !vis[i][cols - 1]) bfs(i, cols - 1, grid);
        }

        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1 && !vis[0][j]) bfs(0, j, grid);
            if (grid[rows - 1][j] == 1 && !vis[rows - 1][j]) bfs(rows - 1, j, grid);
        }

        // Step 2: Count unvisited land cells (enclaves)
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * BFS to mark all land cells connected to the starting boundary cell.
     *
     * @param r    starting row
     * @param c    starting column
     * @param grid the grid
     */
    private void bfs(int r, int c, int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        vis[r][c] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cr = curr[0], cc = curr[1];

            for (int[] dir : directions) {
                int nr = cr + dir[0], nc = cc + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                        grid[nr][nc] == 1 && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
