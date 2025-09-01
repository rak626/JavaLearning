package DSA.graph;

/**
 * Problem: Flood Fill
 * Link: <a href="https://leetcode.com/problems/flood-fill/description/">Click here</a>
 * Difficulty: Medium
 * Tags: graph
 * <p>
 * <p><b>Approach:</b></p>
 * <ul>
 *     <li>Use Depth-First Search (DFS) to explore the grid from the starting pixel.</li>
 *     <li>Only continue DFS on neighboring pixels that match the original color.</li>
 *     <li>Update each visited pixel to the new color.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(m × n)</p>
 * <ul>
 *     <li>In the worst case, we may visit every pixel in the image.</li>
 * </ul>
 *
 * <p><b>Space Complexity:</b> O(m × n)</p>
 * <ul>
 *     <li>Due to the recursion stack in the worst case (all pixels are the same color).</li>
 * </ul>
 */
public class __G9__FloodFill {
    /**
     * Performs flood fill on a copy of the image and returns the modified copy.
     *
     * @param image     The original image grid (not modified)
     * @param sr        Starting row index
     * @param sc        Starting column index
     * @param newColor  The new color to apply
     * @return A new image grid with flood fill applied
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;

        // Deep copy of original image
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            result[i] = image[i].clone();
        }

        int originalColor = image[sr][sc];
        if (originalColor == newColor) return result; // no changes needed

        boolean[][] visited = new boolean[m][n];
        dfs(result, visited, sr, sc, originalColor, newColor);

        return result;
    }

    /**
     * DFS helper to apply flood fill to connected pixels of the same color.
     */
    private void dfs(int[][] image, boolean[][] visited, int i, int j, int originalColor, int newColor) {
        int m = image.length, n = image[0].length;

        // boundary + already visited + wrong color
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || image[i][j] != originalColor) {
            return;
        }

        visited[i][j] = true;
        image[i][j] = newColor;

        // directions (down, up, right, left)
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dirs) {
            dfs(image, visited, i + d[0], j + d[1], originalColor, newColor);
        }
    }
}