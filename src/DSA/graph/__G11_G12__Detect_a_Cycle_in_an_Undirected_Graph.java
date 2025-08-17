package DSA.graph;

import java.util.*;

/**
 * Problem: Detect Cycle in an Undirected Graph
 * <ul>
 *     <li>Link: <a href="https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1">GFG</a></li>
 *     <li>Difficulty: Medium</li>
 *     <li>Tags: Graph, Breadth-First Search (BFS)</li>
 * </ul>
 *
 * Approach:
 * <ul>
 *     <li>Given an edge list, convert it to an adjacency list to represent the undirected graph.</li>
 *     <li>Use Breadth-First Search (BFS) to traverse each connected component of the graph.</li>
 *     <li>Track the parent of each node during BFS to differentiate between a cycle and a valid bidirectional edge.</li>
 *     <li>If a visited node is encountered again and is not the parent of the current node, a cycle exists.</li>
 *     <li>Return true if any cycle is detected during traversal; otherwise, return false.</li>
 * </ul>
 *
 * Time Complexity:
 * <ul>
 *     <li>O(V + E) — where V is the number of vertices and E is the number of edges.</li>
 * </ul>
 *
 * Space Complexity:
 * <ul>
 *     <li>O(V + E) — for the adjacency list and the visited array.</li>
 * </ul>
 */
public class __G11_G12__Detect_a_Cycle_in_an_Undirected_Graph {
    private boolean[] vis;

    public boolean isCycle(int V, int[][] edges) {
        vis = new boolean[V];

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // Initialize all V nodes in adjList
        for (int i = 0; i < V; i++) {
            adjList.put(i, new ArrayList<>());
        }

        // Build undirected adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Traverse each connected component
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (detectCycle(adjList, i)) {
                    return true;
                }
                // for dfs
//                if (dfs(adjList, i, -1)) {
//                    return true;
//                }
            }
        }
        return false;
    }

    // bfs version of detectCycle
    private boolean detectCycle(Map<Integer, List<Integer>> adjList, int src) {
        Deque<int[]> q = new ArrayDeque<>();
        vis[src] = true;
        q.offer(new int[]{src, -1});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int node = poll[0];
            int parent = poll[1];

            for (int neighbor : adjList.get(node)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.offer(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    return true; // cycle found
                }
            }
        }

        return false;
    }


    // dfs version of detect cycle
    private boolean dfs(Map<Integer, List<Integer>> adjList, int node, int parent) {
        vis[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!vis[neighbor]) {
                if (dfs(adjList, neighbor, node)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // found a back edge (cycle)
            }
        }

        return false;
    }
}
