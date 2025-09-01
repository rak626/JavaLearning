package DSA.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem: Topological Sort (DFS Approach)
 * <ul>
 *   <li>Link: <a href="https://www.geeksforgeeks.org/problems/topological-sort/1">GFG - Topological Sort</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Graph, DFS, Topological Sorting</li>
 * </ul>
 *
 * <p>
 * Topological sort of a Directed Acyclic Graph (DAG) is a linear ordering
 * of its vertices such that for every directed edge <code>u → v</code>,
 * vertex <code>u</code> appears before vertex <code>v</code> in the ordering.
 * </p>
 *
 * <h3>Approach (DFS Post-order):</h3>
 * <ul>
 *   <li>Represent the graph as an adjacency list.</li>
 *   <li>Perform DFS from each unvisited vertex.</li>
 *   <li>During DFS:
 *     <ul>
 *       <li>Explore all neighbors of the node recursively.</li>
 *       <li>After exploring all neighbors, add the node to the result list (post-order insertion).</li>
 *     </ul>
 *   </li>
 *   <li>Finally, reverse the result list to obtain the topological ordering.</li>
 *   <li><b>Note:</b> Topological sort is only valid for DAGs (no cycles).</li>
 * </ul>
 *
 * <h3>Example:</h3>
 * <pre>
 * Input:
 * V = 6
 * Edges = [[5,2],[5,0],[4,0],[4,1],[2,3],[3,1]]
 *
 * Output: [5,4,2,3,1,0]
 * Explanation:
 * - A valid ordering is 5 → 2 → 3 → 1 and 4 → 1, 0.
 * - One possible topological sort is [5,4,2,3,1,0].
 * </pre>
 *
 * <h3>Complexity:</h3>
 * <ul>
 *   <li>Time: O(V + E) — Each vertex and edge is processed exactly once.</li>
 *   <li>Space: O(V + E) — For adjacency list, visited array, recursion stack.</li>
 * </ul>
 */
public class __G21__TopoSort_DFS {

    /**
     * Performs topological sorting of a Directed Acyclic Graph using DFS.
     *
     * @param V     Number of vertices (0-indexed).
     * @param edges Directed edges of the graph (u → v).
     * @return A list representing the topological order of vertices.
     */
    public static List<Integer> topoSort(int V, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        // Step 2: DFS to generate post-order list
        boolean[] visited = new boolean[V];
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, order);
            }
        }

        // Step 3: Reverse post-order to get topological sort
        Collections.reverse(order);
        return order;
    }

    /**
     * DFS traversal that adds nodes to order list in post-order.
     */
    private static void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> order) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, order);
            }
        }
        order.add(node); // post-order insertion
    }
}
