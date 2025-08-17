package DSA.graph;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Depth First Search (DFS)
 * Difficulty: Medium
 * Tags: graph, dfs
 *
 * <p><strong>Approach:</strong></p>
 * <ul>
 *     <li>Performs a recursive depth-first search starting from node 0.</li>
 *     <li>Marks each visited node using a boolean array to avoid revisiting.</li>
 *     <li>Explores as deep as possible along each branch before backtracking.</li>
 * </ul>
 *
 * <p><strong>Use Cases:</strong></p>
 * <ul>
 *     <li>Graph traversal</li>
 *     <li>Cycle detection</li>
 *     <li>Topological sorting</li>
 *     <li>Solving puzzles or games with backtracking</li>
 * </ul>
 *
 * <p><strong>Time Complexity:</strong> O(V + E)</p>
 * <p><strong>Space Complexity:</strong> O(V)</p>
 * <ul>
 *     <li>For visited array and recursion stack in the worst case</li>
 * </ul>
 *
 * <p><strong>Note:</strong> This implementation starts DFS from node 0 and assumes the graph is connected.
 * For disconnected graphs, a loop over all nodes is needed.</p>
 */
public class __G6__DepthFirstSearch {
    private List<Integer> result;
    private boolean[] vis;

    /**
     * Performs depth-first traversal of a graph starting from node 0.
     *
     * @param V   The number of vertices in the graph.
     * @param adj The adjacency list representation of the graph.
     * @return A list of nodes in the order they are visited by DFS.
     */
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        result = new ArrayList<>();
        vis = new boolean[V];
        dfs(0, adj);
        return result;
    }

    /**
     * Recursive helper method to perform DFS from a given node.
     *
     * @param node The current node being visited.
     * @param adj  The adjacency list of the graph.
     */
    private void dfs(int node, List<List<Integer>> adj) {
        vis[node] = true;
        result.add(node);
        for (Integer v : adj.get(node)) {
            if (!vis[v]) {
                dfs(v, adj);
            }
        }
    }
}

