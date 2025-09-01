package DSA.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Problem: Course Schedule
 * <ul>
 *   <li>Link: <a href="https://leetcode.com/problems/course-schedule/description/">LeetCode 207. Course Schedule</a></li>
 *   <li>Difficulty: Medium</li>
 *   <li>Tags: Graph, Topological Sort, BFS</li>
 * </ul>
 *
 * <p>
 * You are given <code>numCourses</code> courses labeled from 0 to numCourses-1,
 * and a list of prerequisite pairs where <code>[a, b]</code> means you must take
 * course <code>b</code> before course <code>a</code>.
 * </p>
 *
 * <p>
 * The task is to determine if it is possible to finish all courses.
 * </p>
 *
 * <h3>Approach (Kahn’s Algorithm – BFS Topological Sort):</h3>
 * <ul>
 *   <li>Build an adjacency list where an edge represents a prerequisite relation.</li>
 *   <li>Maintain an indegree array to track how many prerequisites each course has.</li>
 *   <li>Push all courses with indegree 0 into a queue (they can be taken immediately).</li>
 *   <li>Process the queue:
 *     <ul>
 *       <li>Take a course, reduce indegree of its neighbors (dependent courses).</li>
 *       <li>If a neighbor’s indegree becomes 0, push it into the queue.</li>
 *     </ul>
 *   </li>
 *   <li>If we can process all courses → return true; else false (cycle detected).</li>
 * </ul>
 *
 * <p>
 * Example:
 * <pre>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: Take course 0 → then course 1.
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: Cycle exists (0 → 1 → 0), cannot finish all courses.
 * </pre>
 *
 * <p>
 * Time Complexity: O(V + E) — each course and prerequisite processed once.<br>
 * Space Complexity: O(V + E) — adjacency list, indegree array, and queue.
 * </p>
 */
public class __G24__CourseSchedule_1 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {
            int course = p[0], prereq = p[1];
            adj.get(prereq).add(course); // prereq → course
            indegree[course]++;
        }

        // Step 2: Add courses with no prerequisites
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        // Step 3: Process courses in topological order
        int taken = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            taken++;
            for (int next : adj.get(course)) {
                if (--indegree[next] == 0) queue.offer(next);
            }
        }

        // Step 4: If all courses are taken → possible, else cycle exists
        return taken == numCourses;
    }
}
