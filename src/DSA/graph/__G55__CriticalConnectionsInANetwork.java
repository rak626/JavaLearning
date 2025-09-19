package DSA.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Critical Connections in a Network
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/critical-connections-in-a-network/description/">LeetCode</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Graph, DFS, Tarjan's Algorithm, Bridges</li>
 * </ul>
 *
 * <p>Problem Intuition:
 * <br>
 * In a network (graph), a critical connection (bridge) is an edge that, if removed,
 * increases the number of connected components. In other words, removing it disconnects
 * some part of the network.
 * </p>
 *
 * <p>Algorithm Overview (Tarjan's Algorithm for Bridges):
 * <ol>
 *   <li>Perform a Depth-First Search (DFS) traversal of the graph.</li>
 *   <li>Assign each node a <b>discovery time (tin)</b> — the time when we first visit the node.</li>
 *   <li>Compute <b>low[node]</b> — the earliest discovered node reachable from this node or its subtree via DFS.</li>
 *   <li>If for an edge u → v, <code>low[v] > tin[u]</code>, it means there is no back-edge connecting
 *       v (or its subtree) to u or any of u’s ancestors — this edge is a bridge.</li>
 *   <li>Use a parent parameter in DFS to avoid trivial back-edges to immediate parent.</li>
 * </ol>
 * </p>
 *
 * <p>Why It Works:
 * <br>
 * The <b>low-link value</b> represents the “earliest visited node reachable from this node.”
 * <ul>
 *   <li>If low[neighbor] > tin[current], there is no alternative path from neighbor to
 *       current’s ancestors. Therefore, removing this edge disconnects the graph.</li>
 *   <li>If low[neighbor] <= tin[current], there exists a back edge that connects neighbor (or
 *       its subtree) to current or its ancestors, so the edge is not critical.</li>
 * </ul>
 * </p>
 *
 * <p>Time Complexity: O(V + E) — we visit every vertex and edge once.</p>
 * <p>Space Complexity: O(V + E) — adjacency list + O(V) arrays + recursion stack.</p>
 *
 * <p>Approach to Revisiting:
 * <ol>
 *   <li>Recall that DFS + low-link values detect connectivity patterns in a graph.</li>
 *   <li>Bridges are edges that are the only path to reach part of the graph.</li>
 *   <li>Focus on the core formula: <code>if (low[neighbor] > tin[node]) → bridge</code>.</li>
 *   <li>Parent check is crucial: avoid counting the immediate back edge to parent as a bridge.</li>
 * </ol>
 * </p>
 */
public class __G55__CriticalConnectionsInANetwork {

    /** Global timer to assign discovery times to nodes */
    private int timer;

    /**
     * Finds all critical connections (bridges) in an undirected network graph.
     *
     * @param n number of nodes in the graph
     * @param connections list of undirected edges in the graph
     * @return list of critical connections (bridges)
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Step 1: Build adjacency list representation
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }

        // Step 2: Initialize DFS bookkeeping arrays
        int[] tin = new int[n];       // discovery time of each node
        int[] low = new int[n];       // lowest reachable discovery time from this node
        boolean[] vis = new boolean[n]; // visited nodes
        List<List<Integer>> bridges = new ArrayList<>();
        timer = 1;

        // Step 3: Start DFS from node 0 (can also loop through all nodes if graph not connected)
        dfs(0, -1, adj, vis, tin, low, bridges);

        return bridges;
    }

    /**
     * DFS traversal to compute discovery and low-link values, identifying critical connections.
     *
     * @param node current node in DFS
     * @param parent parent of the current node to avoid trivial back-edges
     * @param adj adjacency list of the graph
     * @param vis visited array
     * @param tin discovery time array
     * @param low lowest reachable time array
     * @param bridges list to store all bridges found
     */
    private void dfs(int node, int parent, List<List<Integer>> adj, boolean[] vis,
                     int[] tin, int[] low, List<List<Integer>> bridges) {
        vis[node] = true;
        tin[node] = low[node] = timer++; // assign discovery time

        for (int nei : adj.get(node)) {
            if (nei == parent) continue; // ignore the immediate back edge to parent

            if (vis[nei]) {
                // Already visited neighbor → back-edge
                low[node] = Math.min(low[node], tin[nei]);
            } else {
                // DFS on unvisited neighbor
                dfs(nei, node, adj, vis, tin, low, bridges);
                low[node] = Math.min(low[node], low[nei]);

                // Bridge check: no back edge from neighbor to current or above
                if (low[nei] > tin[node]) {
                    bridges.add(Arrays.asList(node, nei));
                }
            }
        }
    }
}
