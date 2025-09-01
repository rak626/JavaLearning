package DSA.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: Topological Sort (BFS - Kahn's Algorithm)
 * <ul>
 *   <li>Link: <a href="https://www.geeksforgeeks.org/problems/topological-sort/1">GFG</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Graph, Breadth-First Search (BFS), Topological Sorting</li>
 * </ul>
 *
 * Approach:
 * <ul>
 *   <li>Build an adjacency list from the edge list.</li>
 *   <li>Compute indegree[]: number of incoming edges for each node.</li>
 *   <li>Push all nodes with indegree = 0 into a queue.</li>
 *   <li>While the queue is not empty:
 *     <ul>
 *       <li>Pop a node, add it to the topological order.</li>
 *       <li>For each neighbor:
 *         <ul>
 *           <li>Decrease its indegree.</li>
 *           <li>If indegree becomes 0, push it into the queue.</li>
 *         </ul>
 *       </li>
 *     </ul>
 *   </li>
 *   <li>Result list will contain the topological order.</li>
 * </ul>
 *
 * Time Complexity:
 * <ul>
 *   <li>O(V + E) — Each vertex and edge is processed once.</li>
 * </ul>
 *
 * Space Complexity:
 * <ul>
 *   <li>O(V + E) — Adjacency list, indegree array, and queue.</li>
 * </ul>
 */
public class __G22__TopoSort_BFS {

    /**
     * Performs topological sorting of a DAG using BFS (Kahn’s Algorithm).
     *
     * @param V     Number of vertices (0-indexed).
     * @param edges Directed edges of the graph (u -> v).
     * @return List representing topological order of vertices.
     */
    public static List<Integer> topoSort(int V, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[V];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        // Step 2: Initialize queue with nodes having indegree = 0
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        // Step 3: Process nodes
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) q.offer(neighbor);
            }
        }

        return order; // Topological order
    }
}


// Q.1 How to recognize that which problem need to use topo sort ?