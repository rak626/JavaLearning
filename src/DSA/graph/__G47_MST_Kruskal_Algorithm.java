package DSA.graph;

import java.util.Arrays;
import java.util.Comparator;

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
public class __G47_MST_Kruskal_Algorithm {

    /**
     * Compute MST weight and edges using Prim's Algorithm
     *
     * @param n     number of vertices
     * @param edges edges in the form {u, v, w}
     * @return total weight of MST
     */
    public int kruskalMST(int n, int[][] edges) {
        int[][] sortedEdges = Arrays.copyOf(edges, edges.length);
        Arrays.sort(sortedEdges, Comparator.comparingInt(edge -> edge[2]));
        DisjointSet ds = new DisjointSet(n);
        int mstWt = 0;
        for (var e : sortedEdges) {
            int u = e[0], v = e[1], w = e[2];
            if (ds.find(u) != ds.find(v)) {
                mstWt += w;
                ds.unionBySize(u, v);
            }
        }
        return mstWt;
    }
}
