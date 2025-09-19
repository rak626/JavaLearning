package DSA.graph;

import DSA.utils.DisjointSet;

/**
 * Problem: Number Of Operations To Make Network Connected
 * <ul>
 * <li>Link: <a href="https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/">Number Of Operations To Make Network Connected</a></li>
 * <li>Difficulty: Medium</li>
 * <li>Tags: graph, union-find, disjoint-set</li>
 * </ul>
 * <p>
 * Approach:
 * <ol>
 *   <li>Check if the number of connections is at least n-1. If not, return -1.</li>
 *   <li>Use Disjoint Set Union (DSU) to merge connected computers.</li>
 *   <li>Count the number of connected components by checking how many nodes are their own parent.</li>
 *   <li>To connect all components, we need (components - 1) extra connections.</li>
 * </ol>
 * <p>
 * Key Insights:
 * <ul>
 *   <li>Minimum connections required to connect n nodes = n - 1</li>
 *   <li>DSU efficiently tracks connected components</li>
 *   <li>Redundant connections can be used to connect isolated components</li>
 * </ul>
 * <p>
 * Time Complexity: O(N + M * α(N)) where N = number of nodes, M = number of connections
 * Space Complexity: O(N) for parent and size arrays in DSU
 */
public class __G49__NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        DisjointSet ds = new DisjointSet(n);
        for (var con : connections) {
            ds.unionBySize(con[0], con[1]);
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.find(i) == i) components++;
        }

        return components - 1;
    }
}
