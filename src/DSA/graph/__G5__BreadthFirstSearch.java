package DSA.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Problem: Breadth First Search (BFS)
 * Difficulty: Medium
 * Tags: graph, bfs
 * <p>
 * Approach:
 * - Perform a breadth-first search on a graph or tree structure.
 * - Uses a queue to explore nodes level by level.
 * - Can be used for shortest path in unweighted graphs.
 *
 * <p><b>Time Complexity:</b> O(V + E)
 * <br>Where V is the number of vertices and E is the number of edges.</p>
 *
 * <p><b>Space Complexity:</b> O(V)
 * <br>Due to the queue used for BFS.</p>
 */

public class __G5__BreadthFirstSearch {
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[V];
        q.offer(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            result.add(node);
            for (Integer v : adj.get(node)) {
                if (!vis[v]) {
                    q.offer(v);
                    vis[v] = true;
                }
            }
        }
        return result;
    }

}
