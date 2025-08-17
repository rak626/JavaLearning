package DSA.graph;

import java.util.*;


/**
 * Problem: Dijkstra's Algorithm — Shortest Path in Weighted Graph (Non-negative Weights)
 * <ul>
 *   <li>Link: <a href="https://www.geeksforgeeks.org/problems/dijkstra-algorithm/1">GFG</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Graph, Shortest Path, Dijkstra, PriorityQueue, TreeSet</li>
 * </ul>
 *
 *
 * <p>-------------------------------------------------------------------------</p>
 * PriorityQueue Version
 * <p>-------------------------------------------------------------------------</p>
 * <b>Approach:</b>
 * <ul>
 *   <li>Represent the graph as an adjacency list from the given edge list.</li>
 *   <li>Maintain a <code>dist[]</code> array where <code>dist[i]</code> stores the shortest
 *       distance from the source to vertex <code>i</code>.</li>
 *   <li>Use a <code>PriorityQueue</code> (min-heap) to always pick the vertex with the smallest
 *       current distance.</li>
 *   <li>For each extracted vertex:
 *     <ul>
 *       <li>If the current distance is stale (<code>d > dist[u]</code>), skip it.</li>
 *       <li>Relax all edges from this vertex. If a shorter path to a neighbor is found,
 *           update <code>dist[v]</code> and push it into the PQ.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <b>Time Complexity:</b>
 * <ul>
 *   <li>Building adjacency list: <code>O(V + E)</code></li>
 *   <li>Dijkstra traversal: <code>O((V + E) log V)</code> — each PQ operation is <code>O(log V)</code>.</li>
 * </ul>
 *
 * <b>Space Complexity:</b>
 * <ul>
 *   <li>Adjacency list: <code>O(V + E)</code></li>
 *   <li>Distance array: <code>O(V)</code></li>
 *   <li>PriorityQueue: <code>O(V)</code> (may contain duplicates)</li>
 *   <li><b>Total:</b> <code>O(V + E)</code></li>
 * </ul>
 *
 * <p>-------------------------------------------------------------------------</p>
 * <p>TreeSet Version</p>
 * <p>-------------------------------------------------------------------------</p>
 * <b>Approach:</b>
 * <ul>
 *   <li>Same setup as the PQ version — adjacency list and <code>dist[]</code> array.</li>
 *   <li>Use a <code>TreeSet</code> (self-balancing BST) to store pairs
 *       <code>(distance, vertex)</code> in sorted order.</li>
 *   <li>When a shorter path to a vertex is found:
 *     <ul>
 *       <li>Remove the old <code>(distance, vertex)</code> entry from the TreeSet if it exists.</li>
 *       <li>Insert the updated <code>(distance, vertex)</code> pair.</li>
 *     </ul>
 *   </li>
 *   <li>Always extract the vertex with the smallest distance from the TreeSet.</li>
 * </ul>
 *
 * <b>Time Complexity:</b>
 * <ul>
 *   <li>Building adjacency list: <code>O(V + E)</code></li>
 *   <li>Dijkstra traversal: <code>O((V + E) log V)</code> — each TreeSet operation is <code>O(log V)</code>.</li>
 *   <li>No stale entries, so fewer overall operations compared to PQ in practice.</li>
 * </ul>
 *
 * <b>Space Complexity:</b>
 * <ul>
 *   <li>Adjacency list: <code>O(V + E)</code></li>
 *   <li>Distance array: <code>O(V)</code></li>
 *   <li>TreeSet: <code>O(V)</code> (no duplicates)</li>
 *   <li><b>Total:</b> <code>O(V + E)</code></li>
 * </ul>
 */


public class __G32_G33__Dijkstra {
    // Immutable record for node-distance pair
    record Pair(int node, int dist) {
    }

    public int[] dijkstraPriorityQueue(int V, int[][] edges, int src) {
        // Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // remove if graph is directed
        }

        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Min-heap based on distance
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::dist));
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (curr.dist > dist[curr.node]) continue; // skip outdated entry

            for (Pair edge : adj.get(curr.node)) {
                int newDist = dist[curr.node] + edge.dist;
                if (newDist < dist[edge.node]) {
                    dist[edge.node] = newDist;
                    pq.offer(new Pair(edge.node, newDist));
                }
            }
        }
        return dist;
    }


    public int[] dijkstraUsingSet(int V, int[][] edges, int src) {
        // 1. Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // Remove if graph is directed
        }

        // 2. Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // 3. TreeSet sorted by (dist, node)
        TreeSet<Pair> set = new TreeSet<>(
                (a, b) -> (a.dist == b.dist) ? Integer.compare(a.node, b.node) : Integer.compare(a.dist, b.dist)
        );

        set.add(new Pair(src, 0));

        // 4. Process nodes
        while (!set.isEmpty()) {
            Pair curr = set.pollFirst(); // smallest dist
            int u = curr.node;

            for (Pair edge : adj.get(u)) {
                int v = edge.node;
                int newDist = dist[u] + edge.dist;

                if (newDist < dist[v]) {
                    // Remove old entry if it exists
                    if (dist[v] != Integer.MAX_VALUE) {
                        set.remove(new Pair(v, dist[v]));
                    }
                    dist[v] = newDist;
                    set.add(new Pair(v, newDist));
                }
            }
        }
        return dist;
    }
}
