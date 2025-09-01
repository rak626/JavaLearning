package DSA.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem: Shortest Distance in a Binary Maze
 * <ul>
 *   <li>Link: <a href="https://www.geeksforgeeks.org/problems/shortest-distance-in-a-binary-maze/1">
 *       GFG — Shortest Distance in Binary Maze</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Graph, BFS, Dijkstra, Matrix</li>
 * </ul>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>We model the grid as a graph where each cell is a node.</li>
 *   <li>Allowed moves are 4 directions: up, down, left, right.</li>
 *   <li>We apply Dijkstra’s algorithm (since edges are unit weight, BFS also works).</li>
 *   <li>Maintain a distance matrix <code>dist[i][j]</code> representing
 *       shortest distance from source to cell (i, j).</li>
 *   <li>Use a min-heap (PriorityQueue) storing {distance, x, y} to always expand the nearest cell.</li>
 *   <li>Relax neighbors: if <code>dist[x][y] + 1 &lt; dist[nx][ny]</code>, update and push to PQ.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b></p>
 * <ul>
 *   <li>Each cell is processed at most once in PQ → <code>O(N * M)</code>.</li>
 *   <li>Each PQ operation takes <code>O(log(N * M))</code>.</li>
 *   <li><b>Total:</b> <code>O(N * M * log(N * M))</code></li>
 * </ul>
 *
 * <p><b>Space Complexity:</b></p>
 * <ul>
 *   <li>Distance matrix: <code>O(N * M)</code></li>
 *   <li>PriorityQueue: <code>O(N * M)</code></li>
 *   <li><b>Total:</b> <code>O(N * M)</code></li>
 * </ul>
 */
public class __G35__ShortestDistanceInBinaryMaze {

    // 4 possible movement directions
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * Computes the shortest path in a binary maze from source to destination.
     *
     * @param grid        the binary grid (1 = open, 0 = blocked)
     * @param source      start cell [row, col]
     * @param destination target cell [row, col]
     * @return shortest distance from source to destination,
     *         or -1 if no path exists
     */
    public int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length, m = grid[0].length;

        // Distance matrix
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Min-heap PQ: {distance, x, y}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Initialize
        dist[source[0]][source[1]] = 0;
        pq.offer(new int[]{0, source[0], source[1]});

        // Dijkstra's algorithm on grid
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], x = curr[1], y = curr[2];

            // Early stop if destination reached
            if (x == destination[0] && y == destination[1]) {
                return d;
            }

            for (int[] dir : DIRS) {
                int nx = x + dir[0], ny = y + dir[1];

                // Boundary & obstacle check
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || grid[nx][ny] == 0) continue;

                if (d + 1 < dist[nx][ny]) {
                    dist[nx][ny] = d + 1;
                    pq.offer(new int[]{dist[nx][ny], nx, ny});
                }
            }
        }

        return -1; // destination not reachable
    }
}
