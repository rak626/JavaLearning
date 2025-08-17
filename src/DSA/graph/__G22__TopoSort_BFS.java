package DSA.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: Topological Sort (BFS - Kahn's Algorithm)
 * <ul>
 *     <li>Link: <a href="https://www.geeksforgeeks.org/problems/topological-sort/1">GFG</a></li>
 *     <li>Difficulty: Medium</li>
 *     <li>Tags: Graph, Breadth-First Search (BFS), Topological Sorting</li>
 * </ul>
 *
 * Approach:
 * <ul>
 *     <li>Represent the directed graph using an adjacency list built from the edge list.</li>
 *     <li>Compute the indegree (number of incoming edges) for each vertex.</li>
 *     <li>Initialize a queue with all vertices having indegree = 0.</li>
 *     <li>Process vertices from the queue:
 *         <ul>
 *             <li>Remove a vertex from the queue and add it to the result list.</li>
 *             <li>For each neighbor, reduce its indegree by 1.</li>
 *             <li>If a neighbor’s indegree becomes 0, add it to the queue.</li>
 *         </ul>
 *     </li>
 *     <li>Works only for Directed Acyclic Graphs (DAGs).</li>
 * </ul>
 *
 * Time Complexity:
 * <ul>
 *     <li>O(V + E) — each vertex and edge is processed once.</li>
 * </ul>
 *
 * Space Complexity:
 * <ul>
 *     <li>O(V + E) — adjacency list, indegree array, and queue.</li>
 * </ul>
 */
public class __G22__TopoSort_BFS {

    /**
     * Performs topological sorting of a DAG using BFS (Kahn's Algorithm).
     *
     * @param V     Number of vertices (0-indexed).
     * @param edges Directed edges of the graph (u -> v).
     * @return A list representing the topological order of vertices.
     */
    public static List<Integer> topoSort(int V, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[V];

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        // Initialize queue with nodes of indegree 0
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < V; i++)
            if (indegree[i] == 0) {
                q.offer(i);
            }

        List<Integer> order = new ArrayList<>();

        // Process queue
        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);

            for (int neighbor : adj.get(node)) {
                if (--indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return order; // Will contain topological order
    }
}
