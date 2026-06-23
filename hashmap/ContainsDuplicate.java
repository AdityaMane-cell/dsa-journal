package hashmap;

/*
 * Problem: Contains Duplicate
 * Difficulty: Easy
 * Topic: Hashmaps
 * Pattern: 
 *
 * Approach:
 * Use a hashmap to store value->index as we iterate.
 * For each number, check if (target - num) already exists.
 *
 * Time: O(n)
 * Space: O(n)
 */

import java.util.Map;
import java.util.HashMap;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, 1);
        }
        return false;
    }
}
