package DSA.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem: Shortest Path in a Directed Acyclic Graph (DAG)
 * <ul>
 *   <li>Given a DAG with V vertices and E edges (with weights), find the shortest distance
 *       from source (0) to every other vertex.</li>
 *   <li>If a vertex is unreachable, return -1 for that vertex.</li>
 * </ul>
 *
 * Approaches:
 * <ol>
 *   <li><b>BFS (Kahn’s Algorithm / Topological Order)</b>:
 *       <ul>
 *         <li>Compute indegree for each vertex.</li>
 *         <li>Process nodes in topological order using a queue.</li>
 *         <li>Relax edges while updating shortest distance.</li>
 *       </ul>
 *   </li>
 *   <li><b>DFS (Topological Sort)</b>:
 *       <ul>
 *         <li>Perform DFS to generate a topological order (reverse postorder).</li>
 *         <li>Process vertices in topo order, relaxing edges.</li>
 *       </ul>
 *   </li>
 * </ol>
 *
 * Complexity:
 * <ul>
 *   <li>Time: O(V + E) for both approaches.</li>
 *   <li>Space: O(V + E) for adjacency list, plus O(V) for dist[] and topo structures.</li>
 * </ul>
 */
public class __G27__ShortestPathInDAG {

    /** Simple record to represent an edge (neighbor, weight). */
    record Node(int node, int weight) {
    }

    /**
     * Shortest path using BFS (Kahn’s algorithm).
     *
     * @param V number of vertices
     * @param E number of edges
     * @param edges edge list: [u, v, w]
     * @return shortest distance from source (0) to all vertices; -1 if unreachable
     */
    public int[] shortestPathBFS(int V, int E, int[][] edges) {
        // Build adjacency list
        List<List<Node>> adj = IntStream.range(0, V).mapToObj(i -> new ArrayList<Node>()).collect(Collectors.toList());

        int[] indeg = new int[V];
        for (var e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new Node(v, w));
            indeg[v]++;
        }

        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // Kahn’s topo sort + relaxation
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (Node nei : adj.get(u)) {
                int v = nei.node, wt = nei.weight;
                // relaxation
                if (dist[v] > dist[u] + wt) {
                    dist[v] = dist[u] + wt;
                }
                // topo sort part
                indeg[v]--;
                if (indeg[v] == 0) q.offer(v);
            }
        }

        // Convert unreachable nodes to -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
    }

    /**
     * Shortest path using DFS-based Topological Sort.
     *
     * @param V number of vertices
     * @param E number of edges
     * @param edges edge list: [u, v, w]
     * @return shortest distance from source (0) to all vertices; -1 if unreachable
     */
    public int[] shortestPathDFS(int V, int E, int[][] edges) {
        // Build adjacency list
        List<List<Node>> adj = IntStream.range(0, V).mapToObj(i -> new ArrayList<Node>()).collect(Collectors.toList());

        for (var e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new Node(v, w));
        }

        // Topological order via DFS
        boolean[] vis = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) dfs(i, adj, vis, stack);
        }

        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // Process nodes in topo order
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (Node nei : adj.get(u)) {
                    int v = nei.node, wt = nei.weight;
                    // relaxation
                    if (dist[v] > dist[u] + wt) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // Convert unreachable nodes to -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
    }

    /** Helper DFS for topological sorting. */
    private void dfs(int u, List<List<Node>> adj, boolean[] vis, Deque<Integer> stack) {
        vis[u] = true;
        for (Node nei : adj.get(u)) {
            if (!vis[nei.node]) dfs(nei.node, adj, vis, stack);
        }
        stack.push(u); // reverse postorder
    }
}
