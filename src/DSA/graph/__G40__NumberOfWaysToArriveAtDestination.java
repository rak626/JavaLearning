package DSA.graph;

import java.util.*;

/**
 * <h2>Number of Ways to Arrive at Destination</h2>
 *
 * <p>
 * You are given a graph with n cities (0-indexed) and bidirectional roads.
 * Each road has a travel time. The task is to count the number of different
 * shortest paths from city 0 to city n-1. Since the number may be large,
 * return it modulo 1e9+7.
 * </p>
 *
 * <p><b>Problem Link:</b>
 * <a href="https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/">
 * LeetCode 1976 - Number of Ways to Arrive at Destination</a>
 * </p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use Dijkstra’s algorithm to find shortest distances from source.</li>
 *   <li>Track number of ways to reach each node while relaxing edges.</li>
 *   <li>For each neighbor:
 *     <ul>
 *       <li>If a new shortest path is found → update distance and inherit path count.</li>
 *       <li>If another path with the same shortest distance is found → add counts.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O((V + E) log V), where V = number of cities, E = number of roads</p>
 * <p><b>Space Complexity:</b> O(V + E)</p>
 */
public class __G40__NumberOfWaysToArriveAtDestination {

    private static final int MOD = 1_000_000_007;

    /**
     * Helper class to represent (distance, node) in priority queue.
     */
    private record State(long dist, int node) {
    }

    /**
     * Count number of shortest paths from node 0 to node n-1.
     *
     * @param n     number of cities
     * @param roads list of roads [u, v, time]
     * @return number of shortest paths modulo 1e9+7
     */
    public int countPaths(int n, int[][] roads) {
        // Step 1: Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] road : roads) {
            int u = road[0], v = road[1], t = road[2];
            graph.get(u).add(new int[]{v, t});
            graph.get(v).add(new int[]{u, t});
        }

        // Step 2: Distance and ways arrays
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        long[] ways = new long[n];

        dist[0] = 0;
        ways[0] = 1;

        // Step 3: Min-heap for Dijkstra
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(State::dist));
        pq.offer(new State(0, 0));

        // Step 4: Dijkstra’s algorithm
        while (!pq.isEmpty()) {
            State curr = pq.poll();
            long d = curr.dist;
            int u = curr.node;

            if (d > dist[u]) continue; // Skip outdated entry

            for (int[] edge : graph.get(u)) {
                int v = edge[0], t = edge[1];
                long newDist = d + t;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.offer(new State(newDist, v));
                } else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return (int) (ways[n - 1] % MOD);
    }
}
