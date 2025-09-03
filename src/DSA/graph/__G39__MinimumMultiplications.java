package DSA.graph;

import java.util.*;

/**
 * <h2>Minimum Multiplications to Reach End</h2>
 *
 * <p>
 * Given a start number, an end number, and an array arr of multipliers,
 * we can transform `start` into `(start * arr[i]) % 100000` at each step.
 * The task is to find the minimum number of steps required to reach `end`.
 * If not possible, return -1.
 * </p>
 *
 * <p><b>Difficulty:</b> Medium</p>
 * <p><b>Tags:</b> Graph, BFS, Dijkstra</p>
 *
 * <h3>Approach 1: Dijkstra-style</h3>
 * <ul>
 *   <li>Treat each number [0, 99999] as a graph node.</li>
 *   <li>For each node, edges lead to (node * arr[i]) % 100000.</li>
 *   <li>Use a priority queue (Dijkstra) to always expand the node
 *       with the lowest steps so far.</li>
 *   <li>Update distances when finding shorter paths.</li>
 * </ul>
 *
 * <h3>Approach 2: BFS</h3>
 * <ul>
 *   <li>Since each step has equal cost (1), the graph is unweighted.</li>
 *   <li>BFS guarantees shortest path without priority queue overhead.</li>
 *   <li>Visit each state once and expand all neighbors.</li>
 * </ul>
 *
 * <h3>Complexity</h3>
 * <ul>
 *   <li>Dijkstra: Time O(n * 10^5 * log(10^5)), Space O(10^5)</li>
 *   <li>BFS:      Time O(n * 10^5),              Space O(10^5)</li>
 * </ul>
 */
public class __G39__MinimumMultiplications {

    private static final int MOD = 100000;

    /** State for Dijkstra PQ: steps taken and current number */
    private record State(int steps, int number) {}

    /**
     * Dijkstra-style solution.
     *
     * @param arr   multipliers
     * @param start starting number
     * @param end   target number
     * @return minimum steps, -1 if unreachable
     */
    public int minimumMultiplicationsDijkstra(int[] arr, int start, int end) {
        var dist = new HashMap<Integer, Integer>();
        var pq = new PriorityQueue<State>(Comparator.comparingInt(State::steps));

        pq.offer(new State(0, start));
        dist.put(start, 0);

        while (!pq.isEmpty()) {
            var curr = pq.poll();

            if (curr.number == end) return curr.steps;

            if (curr.steps > dist.getOrDefault(curr.number, Integer.MAX_VALUE)) continue;

            for (int num : arr) {
                int next = (curr.number * num) % MOD;
                int nextSteps = curr.steps + 1;

                if (dist.getOrDefault(next, Integer.MAX_VALUE) > nextSteps) {
                    dist.put(next, nextSteps);
                    pq.offer(new State(nextSteps, next));
                }
            }
        }
        return -1;
    }

    /**
     * BFS solution.
     *
     * @param arr   multipliers
     * @param start starting number
     * @param end   target number
     * @return minimum steps, -1 if unreachable
     */
    public int minimumMultiplicationsBFS(int[] arr, int start, int end) {
        int[] dist = new int[MOD];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == end) return dist[curr];

            for (int num : arr) {
                int next = (curr * num) % MOD;
                if (dist[next] > dist[curr] + 1) {
                    dist[next] = dist[curr] + 1;
                    q.offer(next);
                }
            }
        }
        return -1;
    }
}
