package DSA.graph;

import java.util.*;

/**
 * <h2>Cheapest Flights Within K Stops</h2>
 *
 * <p>
 * Given n cities numbered from 0 to n-1 and a list of flights [from, to, price],
 * find the cheapest price from source city to destination city with at most k stops.
 * </p>
 *
 * <p><b>Problem Link:</b>
 * <a href="https://leetcode.com/problems/cheapest-flights-within-k-stops/description/">
 * LeetCode 787</a></p>
 *
 * <p><b>Difficulty:</b> Medium</p>
 * <p><b>Tags:</b> Graph, Priority Queue, Dijkstra</p>
 *
 * <h3>Approach</h3>
 * <ul>
 *   <li>Model cities as nodes and flights as weighted edges.</li>
 *   <li>Use a priority queue to expand the city with the lowest current cost.</li>
 *   <li>Track number of stops to ensure we do not exceed k.</li>
 *   <li>Stop early when reaching destination.</li>
 * </ul>
 *
 * <h3>Complexity</h3>
 * <ul>
 *   <li>Time: O(E log V), E = number of flights, V = number of cities</li>
 *   <li>Space: O(V + E), adjacency list + priority queue</li>
 * </ul>
 */
public class __G38__CheapestFlightsWithinKStops {

    /** Flight to a destination city with a cost */
    private record Flight(int destination, int cost) {
    }

    /** PQ element: total cost so far, current city, stops made */
    private record State(int totalCost, int city, int stops) {
    }

    /**
     * Finds the cheapest price from source to destination with at most k stops.
     *
     * @param n       number of cities
     * @param flights flights array [from, to, price]
     * @param src     source city
     * @param dst     destination city
     * @param k       maximum allowed stops
     * @return minimum cost to reach destination, -1 if not possible
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list
        var adj = new ArrayList<List<Flight>>(n);
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (var flight : flights) adj.get(flight[0]).add(new Flight(flight[1], flight[2]));

        // Distance array to track minimum stops to reach a city
        var minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        // PriorityQueue: expand the lowest-cost city first
        var pq = new PriorityQueue<State>(Comparator.comparingInt(s -> s.totalCost));
        pq.offer(new State(0, src, 0));

        while (!pq.isEmpty()) {
            var curr = pq.poll();

            // Reached destination
            if (curr.city == dst) return curr.totalCost;

            // Skip if exceeded stops limit or already visited with fewer stops
            if (curr.stops > k || curr.stops >= minStops[curr.city]) continue;

            minStops[curr.city] = curr.stops;

            // Explore neighbors
            for (var flight : adj.get(curr.city)) {
                pq.offer(new State(curr.totalCost + flight.cost, flight.destination, curr.stops + 1));
            }
        }

        return -1; // destination unreachable
    }
}
