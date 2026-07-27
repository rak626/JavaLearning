package DSA.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * <h3>Problem: Shortest Path in a Directed Acyclic Graph (DAG)</h3>
 * <p>Problem link: <a href="https://www.geeksforgeeks.org/problems/shortest-path-in-directed-acyclic-graph/1">GeeksForGeeks</a></p>
 * <ul>
 *   <li>Given a DAG with V vertices and E edges (with weights), find the shortest distance
 *       from source (node 0) to every other vertex.</li>
 *   <li>If a vertex is unreachable from 0, return -1 for that vertex.</li>
 * </ul>
 *
 * Core Concept:
 * <ul>
 *   <li>In a DAG, processing vertices in <b>Topological Order</b> guarantees that when a node
 *       {@code u} is processed, all possible paths leading to {@code u} have already been evaluated
 *       and relaxed. Thus, each edge needs to be relaxed only once.</li>
 * </ul>
 *
 * Approaches:
 * <ol>
 *   <li><b>DFS (Topological Sort + Relaxation)</b>:
 *       <ul>
 *         <li>Perform DFS to generate a full topological order (stack push post-order traversal).</li>
 *         <li>Pop from the stack and relax edges for reachable nodes.</li>
 *       </ul>
 *   </li>
 *   <li><b>BFS (Kahn's Algorithm + Relaxation)</b>:
 *       <ul>
 *         <li><b>Phase 1:</b> Compute topological ordering using Kahn's algorithm (enqueue all indegree=0 nodes).</li>
 *         <li><b>Phase 2:</b> Iterate through the topological order and relax outgoing edges.</li>
 *         <li><i>Note:</i> Topological sorting and relaxation must be done in two distinct phases.
 *             Single-pass relaxation during Kahn's queueing fails when there are nodes unreachable from source 0.</li>
 *       </ul>
 *   </li>
 * </ol>
 *
 * Complexity:
 * <ul>
 *   <li>Time: O(V + E) for both approaches.</li>
 *   <li>Space: O(V + E) for adjacency list, plus O(V) for dist[] and topological structures.</li>
 * </ul>
 *
 *
 /**
 * KEY CONCEPTS & FAQ:
 * <p>
 * <h3>1. Why is Topological Sort required?</h3>
 *    - It determines the exact sequence needed to evaluate nodes in a single pass.
 *    - It guarantees that when we process node 'u', ALL incoming paths leading
 *      into 'u' have already been evaluated and finalized.
 * <p>
 * <h3>2. What does Edge Relaxation mean?</h3>
 *    - "Relaxing" an edge (u -> v with weight w) means checking if going through 'u'
 *      provides a shorter path to 'v' than previously known:
 *      if (dist[v] > dist[u] + w) { dist[v] = dist[u] + w; }
 *
 * <h3>3. Walkthrough Example (A -> C vs A -> B -> C): </h3>
 *    - Direct path A -> C has weight 10.
 *    - Path A -> B -> C has total weight 2 (A->B = 1, B->C = 1).
 *    - Topo Sort enforces the processing order: [A, B, C].
 *    - Step 1 (A): Sets dist[B] = 1, dist[C] = 10.
 *    - Step 2 (B): Relaxes edge B -> C, updating dist[C] from 10 down to 2.
 *    - Step 3 (C): When C is finally processed, its distance (2) is 100% final
 *      and optimal. We never have to re-evaluate C or its descendants.
 */
public class __G27__ShortestPathInDAG {

    /** Record to represent an edge (target neighbor, edge weight). */
    private record Node(int node, int weight) {
    }

    /**
     * Shortest path using DFS-based Topological Sort (Preferred Approach).
     * Time Complexity: O(V + E)
     * Space Complexity: O(V + E)
     */
    public int[] shortestPathDFS(int V, int E, int[][] edges) {
        // Build adjacency list
        List<List<Node>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (var e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new Node(v, w));
        }

        // Phase 1: Topological order via DFS
        boolean[] vis = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, stack);
            }
        }

        // Phase 2: Distance array relaxation
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // Process nodes in strict topological order
        while (!stack.isEmpty()) {
            int u = stack.pop();

            // Only relax outgoing edges if u is reachable from source (0)
            if (dist[u] != Integer.MAX_VALUE) {
                for (Node nei : adj.get(u)) {
                    int v = nei.node, wt = nei.weight;
                    if (dist[v] > dist[u] + wt) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // Phase 3: Convert unreachable nodes to -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }

    /** Helper DFS for topological sorting (Post-order insertion). */
    private void dfs(int u, List<List<Node>> adj, boolean[] vis, Deque<Integer> stack) {
        vis[u] = true;
        for (Node nei : adj.get(u)) {
            if (!vis[nei.node]) {
                dfs(nei.node, adj, vis, stack);
            }
        }
        stack.push(u); // Reverse post-order
    }

    /**
     * Shortest path using BFS (Kahn's Algorithm in Two Phases).
     * <p>
     * Time Complexity: O(V + E)
     * Space Complexity: O(V + E)
     */
    public int[] shortestPathBFS(int V, int E, int[][] edges) {
        // Build adjacency list & compute in-degrees
        List<List<Node>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indeg = new int[V];
        for (var e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new Node(v, w));
            indeg[v]++;
        }

        // Phase 1: Kahn's Algorithm to generate complete Topological Sort
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0) q.offer(i); // Enqueue ALL nodes with indegree 0
        }

        List<Integer> topoOrder = new ArrayList<>(V);
        while (!q.isEmpty()) {
            int u = q.poll();
            topoOrder.add(u);
            for (Node nei : adj.get(u)) {
                if (--indeg[nei.node] == 0) {
                    q.offer(nei.node);
                }
            }
        }

        // Phase 2: Relax edges in Topological Order
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int u : topoOrder) {
            if (dist[u] != Integer.MAX_VALUE) {
                for (Node nei : adj.get(u)) {
                    int v = nei.node, wt = nei.weight;
                    if (dist[v] > dist[u] + wt) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // Phase 3: Convert unreachable nodes to -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }
}