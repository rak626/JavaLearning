package DSA.graph;

import java.util.*;

/**
 * Problem: Dijkstra's Algorithm — Print Shortest Path in Weighted Undirected Graph (Non-negative Weights)
 * <ul>
 *   <li>Link: <a href="https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1">
 *       GFG — Shortest Path in Weighted Graph</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Graph, Shortest Path, Dijkstra, PriorityQueue</li>
 * </ul>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Represent the graph as an adjacency list.</li>
 *   <li>Maintain a <code>dist[]</code> array where <code>dist[i]</code> is the shortest distance from source to node i.</li>
 *   <li>Use a <code>PriorityQueue</code> (min-heap) to pick the node with the current shortest distance.</li>
 *   <li>Relax all edges from that node. If a shorter distance is found, update <code>dist[v]</code> and record the parent.</li>
 *   <li>Reconstruct the path from destination back to source using the parent array.</li>
 * </ul>
 *
 * <b>Time Complexity:</b> <code>O((V + E) log V)</code>
 * <b>Space Complexity:</b> <code>O(V + E)</code>
 */
public class __G35__PrintShortestPath_Dijkstra {

    /**
     * Pair record for (distance, node) used in PriorityQueue.
     */
    record Pair(long dist, int node) {
    }

    /**
     * Computes the shortest path from node 1 to node n.
     *
     * @param n     number of vertices
     * @param m     number of edges
     * @param edges edge list [u, v, w]
     * @return list of vertices from 1 → n (shortest path),
     *         or [-1] if no path exists
     */
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        // Build adjacency list: 1-indexed
        List<List<int[]>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        // Distance and parent arrays
        long[] dist = new long[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(parent, -1);

        // Dijkstra’s algorithm
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(Pair::dist));
        dist[1] = 0;
        pq.offer(new Pair(0, 1));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long d = curr.dist();
            int u = curr.node();

            if (d > dist[u]) continue; // stale entry

            for (int[] nei : adj.get(u)) {
                int v = nei[0], w = nei[1];
                long nd = d + w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    parent[v] = u;
                    pq.offer(new Pair(nd, v));
                }
            }
        }

        // If destination is unreachable
        if (dist[n] == Long.MAX_VALUE) {
            return Collections.singletonList(-1);
        }

        // Reconstruct path from n back to 1
        Deque<Integer> stack = new ArrayDeque<>();
        for (int at = n; at != -1; at = parent[at]) {
            stack.push(at);
        }

        return new ArrayList<>(stack);
    }
}
