package DSA.graph;

/**
 * <h2>Floyd-Warshall Algorithm</h2>
 *
 * <p>
 * The Floyd-Warshall algorithm computes shortest paths between all pairs of
 * vertices in a weighted graph. It works with negative edge weights but cannot
 * handle negative weight cycles.
 * </p>
 *
 * <p><b>Problem Links:</b></p>
 * <ul>
 *   <li><a href="https://leetcode.com/problems/network-delay-time/">
 *       LeetCode - Network Delay Time (similar APSP problem)</a></li>
 *   <li><a href="https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/">
 *       GeeksforGeeks - Floyd Warshall Algorithm</a></li>
 * </ul>
 *
 * <p><b>Algorithm Steps:</b></p>
 * <ul>
 *   <li>Initialize a distance matrix with direct edge weights.</li>
 *   <li>Set <code>dist[i][i] = 0</code> for all vertices i.</li>
 *   <li>For each vertex k (acting as an intermediate), update all pairs (i, j) using:
 *       <br><code>dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])</code>
 *   </li>
 *   <li>After processing, if <code>dist[i][i] &lt; 0</code> for any i,
 *       the graph contains a negative cycle.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(V³), where V is the number of vertices</p>
 * <p><b>Space Complexity:</b> O(V²) for the distance matrix</p>
 *
 * <p><b>Applications:</b></p>
 * <ul>
 *   <li>All-pairs shortest path in dense graphs</li>
 *   <li>Finding negative weight cycles</li>
 *   <li>Dynamic programming on graphs</li>
 * </ul>
 */
public class __G42__FloydWarshall {
    private static final int INF = (int) 1e8;

    /**
     * Runs the Floyd-Warshall algorithm on the given graph.
     *
     * @param dist Distance matrix where:
     *             <ul>
     *               <li>dist[i][j] = weight of edge (i → j) if it exists</li>
     *               <li>dist[i][j] = INF if no direct edge exists</li>
     *               <li>dist[i][i] = 0 for all i</li>
     *             </ul>
     *
     * After execution, dist[i][j] contains the shortest distance from i → j.
     * If a negative cycle exists, a warning message is printed.
     */
    public void floydWarshall(int[][] dist) {
        int V = dist.length;

        // Try each vertex as an intermediate "via" node
        for (int via = 0; via < V; via++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // Update distance only if both sub-paths are valid
                    if (dist[i][via] != INF && dist[via][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }

        // Detect negative cycle
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Graph contains a negative weight cycle!");
                return;
            }
        }
    }
}
