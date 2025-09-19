package DSA.graph;

/**
 * Problem: Number Of Provinces
 * <ul>
 * <li>Link: <a href="https://leetcode.com/problems/number-of-provinces/description/">Number Of Provinces</a></li>
 * <li>Difficulty: Medium</li>
 * <li>Tags: graph, disjoint-set, union-find</li>
 * </ul>
 * <p>
 * Approach:
 * <ol>
 *   <li>Use Disjoint Set Union (DSU) to merge connected cities.</li>
 *   <li>Iterate only over upper triangle of adjacency matrix to avoid double-counting.</li>
 *   <li>Count the number of connected components to get number of provinces.</li>
 * </ol>
 * <p>
 * Time Complexity: O(N^2 * α(N)) where N = number of cities
 * Space Complexity: O(N) for DSU
 */
public class __G48__NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    ds.unionBySize(i, j);
                }
            }
        }

        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (ds.find(i) == i) provinces++;
        }
        return provinces;
    }
}
