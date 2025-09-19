package DSA.graph.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: Shortest Path With Alternating Colors
 * <ul>
 * <li>Link: <a href="https://leetcode.com/problems/shortest-path-with-alternating-colors/description/">Shortest Path With Alternating Colors</a></li>
 * <li>Difficulty: Medium</li>
 * <li>Tags: graph</li>
 * </ul>
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O( E * logV)
 * Space: O()
 */
public class ShortestPathWithAlternatingColors {
    private static final int INF = (int) 1e8;

    public int[] shortestAlternatePaths(int n, int[][] redEdges, int[][] blueEdges) {
        var adj = new ArrayList<ArrayList<int[]>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // 0 for red, 1 for blue
        for (var e : redEdges) {
            adj.get(e[0]).add(new int[]{e[1], 0});
        }
        for (var e : blueEdges) {
            adj.get(e[0]).add(new int[]{e[1], 1});
        }

        var dist = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[0][0] = dist[0][1] = 0;

        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1], c = cur[2];
            if (d > dist[u][c]) continue;

            for (var nei : adj.get(u)) {
                int v = nei[0], nc = nei[1];
                if (nc == c) continue;
                else if (d + 1 < dist[v][nc]) {
                    dist[v][nc] = d + 1;
                    pq.offer(new int[]{dist[v][nc], v, nc});
                }
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int ans = Math.min(dist[i][0], dist[i][1]);
            res[i] = (ans == INF ? -1 : ans);
        }
        return res;

    }
}
