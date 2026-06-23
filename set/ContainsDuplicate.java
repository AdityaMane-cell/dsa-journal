package set;

/*
 * Problem: ContainsDuplicate
 * Difficulty: Easy
 * Topic: easy
 *
 * Approach:
 * Use a hashset to store unique values as we iterate.
 * For each number, check if it already exists return true.
 *
 * Time:  O(n)
 * Space: O(n)
 * 
 */

import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
