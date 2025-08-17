package DSA.graph;

/**
 * Problem: Number Of Provinces
 * Link: <a href="https://leetcode.com/problems/number-of-provinces/description/">Click here</a>
 * Difficulty: Medium
 * Tags: graph
 * <p>
 * <p><b>Approach:</b></p>
 * <ul>
 *     <li>Model the isConnected matrix as an adjacency graph.</li>
 *     <li>Use DFS to explore all cities connected directly or indirectly.</li>
 *     <li>Count how many times DFS is launched — that equals the number of provinces.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n^2)</p>
 * <p><b>Space Complexity:</b> O(n)</p>
 */

public class __G7__NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinceCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinceCount++;
            }
        }

        return provinceCount;
    }

    /**
     * Depth-First Search to mark all cities in the same province.
     */
    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;
        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
                dfs(isConnected, visited, neighbor);
            }
        }
    }
}
