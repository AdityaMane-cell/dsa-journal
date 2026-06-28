package hashmap;

/*
 * Problem: Top K Frequent Elements
 * Difficulty: Medium
 * Topic: hashmap
 * Pattern: Top k
 *
 * Approach:
 * Record the pair of key-> count as we iterate through the array.
 * Then sort the Map.Entry is descending form.
 * Then simply pick the top k elements.
 * 
 * 
 * Time:  O(n)
 * Space: O(n)
 * 
 */

import java.util.Arrays;

class TopKFrequentElements {
        public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entry = new ArrayList<>(map.entrySet());
        entry.sort((a,b) -> b.getValue() - a.getValue());
        for(int i = 0; i < k; i++) {
            result[i] = entry.get(i).getKey();
        }
        return result;
    }

}