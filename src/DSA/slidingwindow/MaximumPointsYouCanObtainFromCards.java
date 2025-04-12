package DSA.slidingwindow;

/**
 * Problem: Maximum Points You Can Obtain From Cards
 * Link: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
 * Difficulty: Medium
 * Tags: SlidingWindow
 * <p>
 * Approach:
 * 1. make a window of k.
 * 2. calculate sum of window
 * 3. now delete each element from window from back & add element from right side of array
 * 4. calculate each time which is the maxSum
 * -
 * <p>
 * Time: O(2N)
 * Space: O(1)
 */
public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0, rightSum = 0, maxSum = 0, right = cardPoints.length-1;
        for (int i = 0 ; i < k ; i++) {
            leftSum += cardPoints[i];
        }
        maxSum = leftSum;
        for (int i = k-1 ; i >= 0 ; i--){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[right];
            right--;
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }
}
