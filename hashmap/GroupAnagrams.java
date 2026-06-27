package hashmap;

/*
 * Problem: Group Anagrams
 * Difficulty: Medium
 * Topic: Hashmap
 * pattern: sorted string key
 *
 * Approach:
 * iterate over strings and compute sorted String keys.
 * use sorted keys to initalize list as value then add the valid str.
 * do this until all array is iterated.
 * At last wrap the Collection<List<String> object returned by map.values in ArrayList to return.
 * 
 *
 * Time:  O(n log n)
 * Space: O(n)
 * 
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String key = new String(sorted);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        result = new ArrayList<>(map.values());
        return result;
    }
}
