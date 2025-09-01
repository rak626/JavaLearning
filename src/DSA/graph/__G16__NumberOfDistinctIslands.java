package DSA.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: Number Of Distinct Islands
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/number-of-distinct-islands/">Number Of Distinct Islands</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Graph, DFS, Matrix</li>
 * </ul>
 *
 * <p>
 * Approach:
 * <ul>
 *   <li>Traverse the grid and start DFS from each unvisited land cell (1).</li>
 *   <li>During DFS, record the relative coordinates of each cell w.r.t the starting cell to encode the shape.</li>
 *   <li>Add the shape encoding to a Set to automatically handle duplicates.</li>
 *   <li>The size of the set gives the number of distinct islands.</li>
 * </ul>
 *
 * <p>
 * Time Complexity: O(m * n), where m = rows, n = cols (each cell visited at most once)<br>
 * Space Complexity: O(m * n) for visited array + O(m * n) for storing shapes
 */
public class __G16__NumberOfDistinctIslands {

    private int rows, cols;
    private boolean[][] vis;
    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * Counts the number of distinct islands in the grid.
     *
     * @param grid 2D grid of 0s (water) and 1s (land)
     * @return number of distinct islands
     */
    public int countDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        rows = grid.length;
        cols = grid[0].length;
        vis = new boolean[rows][cols];

        Set<String> shapes = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    List<String> shape = new ArrayList<>();
                    dfs(grid, i, j, i, j, shape);
                    shapes.add(String.join(",", shape));
                }
            }
        }

        return shapes.size();
    }

    /**
     * DFS to explore an island and record its shape relative to the starting cell.
     *
     * @param grid  the grid
     * @param row   current row
     * @param col   current column
     * @param baseR starting row of the island
     * @param baseC starting column of the island
     * @param shape list to record the relative coordinates of the island
     */
    private void dfs(int[][] grid, int row, int col, int baseR, int baseC, List<String> shape) {
        vis[row][col] = true;
        shape.add((row - baseR) + ":" + (col - baseC));

        for (int[] dir : dirs) {
            int nr = row + dir[0], nc = col + dir[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1 && !vis[nr][nc]) {
                dfs(grid, nr, nc, baseR, baseC, shape);
            }
        }
    }
}
