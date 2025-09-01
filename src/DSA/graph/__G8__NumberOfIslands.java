package DSA.graph;

/**
 * Problem: Number Of Islands
 * Link: <a href="https://leetcode.com/problems/number-of-islands/description/">Click here</a>
 * Difficulty: Medium
 * Tags: graph
 * <p>
 * <p><b>Approach:</b></p>
 * <ul>
 *     <li>Use Depth-First Search (DFS) to explore the grid.</li>
 *     <li>Instead of modifying the input grid, use a separate visited[][] array.</li>
 *     <li>Iterate through every cell in the grid:</li>
 *     <ul>
 *         <li>If a cell contains '1' (land) and is not visited, it's the start of a new island.</li>
 *         <li>Launch DFS from that cell to mark the entire island as visited.</li>
 *     </ul>
 *     <li>Count how many times DFS is launched — this is the number of islands.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(m × n)</p>
 * <ul>
 *     <li>We visit each cell once, performing constant work per cell.</li>
 * </ul>
 *
 * <p><b>Space Complexity:</b> O(m × n)</p>
 * <ul>
 *     <li>visited[][] takes O(m × n) space.</li>
 *     <li>The recursion stack in DFS can go up to O(m × n) in the worst case (all land).</li>
 * </ul>
 */
public class __G8__NumberOfIslands {
    /**
     * Returns the number of islands in the given grid.
     *
     * @param grid 2D character grid of '1's (land) and '0's (water)
     * @return Number of islands
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Performs DFS from the given cell and marks all connected land as visited.
     *
     * @param grid    2D grid representing land and water
     * @param visited Visited array to avoid revisiting cells
     * @param i       Current row index
     * @param j       Current column index
     */
    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length, n = grid[0].length;

        // boundary + already visited + water check
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1' || visited[i][j]) return;

        visited[i][j] = true;

        // directions: down, up, right, left
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dirs) {
            dfs(grid, visited, i + d[0], j + d[1]);
        }
    }
}