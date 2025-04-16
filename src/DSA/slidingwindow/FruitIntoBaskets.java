package DSA.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Fruit Into Baskets
 * Link: <a href="https://leetcode.com/problems/fruit-into-baskets/description/">...</a>
 * Difficulty: Medium
 * Tags: SlidingWindow
 * <p>
 * Approach:
 * 1. whenever map size is greater than two, reduce window size from left
 * -
 * <p>
 * Time: O(2N)
 * Space: O(N) ~ O(1) as map size is fixed to 2
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, right = 0;
        int maxFruits = 0;
        Map<Integer, Integer> fruitCount = new HashMap<>();
        for (; right < n; right++) {
            fruitCount.merge(fruits[right], 1, Integer::sum);
            while (fruitCount.size() > 2) {
                fruitCount.merge(fruits[left], -1, Integer::sum);
                if (fruitCount.get(fruits[left]) == 0) {
                    fruitCount.remove(fruits[left]);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;
    }
}
