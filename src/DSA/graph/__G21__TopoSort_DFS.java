package DSA.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem: Topological Sort (DFS Approach)
 * <ul>
 *     <li>Link: <a href="https://www.geeksforgeeks.org/problems/topological-sort/1">GFG</a></li>
 *     <li>Difficulty: Medium</li>
 *     <li>Tags: Graph, Depth-First Search (DFS), Topological Sorting</li>
 * </ul>
 *
 * Approach:
 * <ul>
 *     <li>Represent the directed graph using an adjacency list built from the edge list.</li>
 *     <li>Perform DFS on each unvisited vertex.</li>
 *     <li>During DFS, after exploring all neighbors of a node, add it to the result list (post-order).</li>
 *     <li>Reverse the result list at the end to obtain the topological order.</li>
 *     <li>Works only for Directed Acyclic Graphs (DAGs).</li>
 * </ul>
 *
 * Time Complexity:
 * <ul>
 *     <li>O(V + E) — V vertices and E edges are processed exactly once.</li>
 * </ul>
 *
 * Space Complexity:
 * <ul>
 *     <li>O(V + E) — adjacency list + recursion stack + visited array.</li>
 * </ul>
 */
public class __G21__TopoSort_DFS {

    /**
     * Performs topological sorting of a DAG using DFS.
     *
     * @param V     Number of vertices (0-indexed).
     * @param edges Directed edges of the graph (u -> v).
     * @return A list representing the topological order of vertices.
     */
    public static List<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        boolean[] visited = new boolean[V];
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < V; i++)
            if (!visited[i]) {
                dfs(i, adj, visited, order);
            }

        Collections.reverse(order);
        return order;
    }

    private static void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> order) {
        visited[node] = true;
        for (int neighbor : adj.get(node))
            if (!visited[neighbor]) dfs(neighbor, adj, visited, order);
        order.add(node); // post-order
    }
}

