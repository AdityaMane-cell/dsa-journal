/*
 * Problem: Contains Duplicate
 * Difficulty: Easy
 * Topic: Hashmaps
 * Pattern: prefix/suffix product
 *
 * Approach:
 * calculate left auxilary array in which every left[i] is the prefix product including left[i]
 * similarly calculate right auxiliary array where every right[i] is suffix product including right[i]
 * Then simply elements from left or right or both as depending on index.
 * 
 * 
 * Time: O(n)
 * Space: O(n)
 */

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelfOptimized(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        right[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            right[i] = nums[i] * right[i+1];
        }
        right[0] = right[1];
        for(int i=1; i<n; i++) {
            if(i == n-1) {
                right[i] = nums[i-1];
            } else {
                right[i] = nums[i-1] * right[i+1];
            }
            nums[i] *= nums[i-1];
        }
        return right;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // calculate left auxiliar array
        int[] left = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = nums[i] * left[i - 1];
        }

        // calculate right auxilary array
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums[i] * right[i + 1];
        }

        // calculate answer
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                answer[i] = right[i + 1];
            } else if (i == n - 1) {
                answer[i] = left[i - 1];
            } else {
                answer[i] = left[i - 1] * right[i + 1];
            }
        }
        return answer;
    }

}
