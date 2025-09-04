package DSA.graph;

import java.util.*;

/**
 * <h2>Minimum Spanning Tree using Prim's Algorithm</h2>
 *
 * <p>
 * Given a weighted, undirected graph with {@code n} vertices and a list of edges,
 * compute the Minimum Spanning Tree (MST), i.e., a subset of edges connecting all
 * vertices with the minimum total edge weight without cycles.
 * </p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Build an adjacency list from the given edges.</li>
 *   <li>Use Prim's algorithm with a priority queue to greedily pick the smallest edge
 *       connecting the MST to a new vertex.</li>
 *   <li>Maintain a parent array to track MST edges.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(E log V), where E is the number of edges.</p>
 * <p><b>Space Complexity:</b> O(V + E), for adjacency list and auxiliary structures.</p>
 */
public class __G45_MST_Prims_Algorithm {

    /**
     * Compute MST weight and edges using Prim's Algorithm
     *
     * @param n     number of vertices
     * @param edges edges in the form {u, v, w}
     * @return total weight of MST
     */
    public int primsMST(int n, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        boolean[] vis = new boolean[n];
//        int[] parent = new int[n];
//        Arrays.fill(parent, -1);

        // Min-heap: {weight, node, parent}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, -1}); // start from node 0

        int sum = 0;
        List<int[]> mstEdges = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int w = curr[0], u = curr[1], p = curr[2];

            if (vis[u]) continue;

            vis[u] = true;
            sum += w;
//            parent[u] = p;

            if (p != -1) mstEdges.add(new int[]{p, u});

            for (int[] nei : adj.get(u)) {
                int v = nei[0], weight = nei[1];
                if (!vis[v]) pq.offer(new int[]{weight, v, u});
            }
        }

        // Debug / Output
        System.out.println("MST Weight = " + sum);
        System.out.print("MST Edges  = ");
        for (int[] e : mstEdges) System.out.print(Arrays.toString(e) + " ");
        System.out.println();

        return sum;
    }
}
