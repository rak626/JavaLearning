package DSA.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 01 Matrix
 * <ul>
 * <li>Link: <a href="https://leetcode.com/problems/01-matrix/description/">Click here</a></li>
 * <li>Difficulty: Medium</li>
 * <li>Tags: Graph, BFS, Matrix</li>
 * </ul>
 * <p>
 * Approach:
 * - Multi-source BFS: Push all 0s into the queue initially.
 * - Perform BFS to calculate minimum distance to the nearest 0 for each 1.
 * </p>
 *
 * Time: O(m * n) — Each cell is visited at most once
 * Space: O(m * n) — For the queue and visited matrix
 */

public class __G13__01__Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int[][] result = new int[rows][cols];
        Deque<int[]> q = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0) {
                    vis[r][c] = true;
                    q.offer(new int[]{r, c, 0});
                }
            }
        }

        int[][] distance = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int row = pos[0], col = pos[1], step = pos[2];
            result[row][col] = step;

            for (var dist : distance) {
                int nrow = row + dist[0], ncol = col + dist[1];

                if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    q.offer(new int[]{nrow, ncol, step + 1});
                }
            }
        }

        return result;
    }
}
