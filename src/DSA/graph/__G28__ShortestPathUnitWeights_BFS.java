package DSA.graph;

import java.util.*;

/**
 * Problem: Shortest Path in Undirected Graph with Unit Weights
 * <ul>
 *     <li>We are given an undirected graph of V vertices and E edges.</li>
 *     <li>Each edge has unit weight (cost = 1).</li>
 *     <li>We need to find the shortest path distance from a given source node
 *         to every other vertex.</li>
 *     <li>If a vertex is not reachable, mark its distance as -1.</li>
 * </ul>
 *
 * <p><b>Intuition:</b></p>
 * <ul>
 *     <li>Normally, Dijkstra’s algorithm is required for shortest path in weighted graphs.</li>
 *     <li>But since all edges have equal weight (1), we can simply use <b>BFS</b>.</li>
 *     <li>BFS ensures that the first time we visit a node is via the shortest path.</li>
 * </ul>
 *
 * <p><b>Algorithm:</b></p>
 * <ol>
 *     <li>Build an adjacency list representation of the graph.</li>
 *     <li>Initialize a distance array with infinity (Integer.MAX_VALUE).</li>
 *     <li>Set distance of source node = 0.</li>
 *     <li>Run BFS:
 *         <ul>
 *             <li>Pop a node u from queue.</li>
 *             <li>For each neighbor v of u:
 *                 <ul>
 *                     <li>If dist[v] > dist[u] + 1 → update dist[v].</li>
 *                     <li>Push v into queue.</li>
 *                 </ul>
 *             </li>
 *         </ul>
 *     </li>
 *     <li>After BFS, replace unreached nodes (∞) with -1.</li>
 * </ol>
 *
 * <p><b>Complexity:</b></p>
 * <ul>
 *     <li>Time: O(V + E) – BFS visits every vertex and edge once.</li>
 *     <li>Space: O(V + E) – adjacency list, distance array, and queue.</li>
 * </ul>
 */
public class __G28__ShortestPathUnitWeights_BFS {

    /**
     * Computes the shortest path from a given source node to all other nodes
     * in an undirected graph with unit edge weights.
     *
     * @param V     Number of vertices in the graph
     * @param edges 2D array of edges, where each edge is [u, v] (undirected)
     * @param src   The source vertex from which distances are calculated
     * @return An integer array of size V where dist[i] is the shortest distance
     *         from src to i. If node i is unreachable, dist[i] = -1.
     */
    public int[] shortestPath(int V, int[][] edges, int src) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }

        // Step 2: Distance array initialized with infinity
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: BFS queue
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(src);

        // Step 4: Standard BFS
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (dist[v] > dist[u] + 1) {
                    dist[v] = dist[u] + 1;
                    q.offer(v);
                }
            }
        }

        // Step 5: Replace unreachable nodes with -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
