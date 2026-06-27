package hashmap;

/*
 * Problem: Valid Anagram
 * Difficulty: Easy
 * Topic: Hashmap
 * Pattern: storing character count
 *
 * Approach:
 * Use a hashmap to store char->count of a string as we iterate.
 * then if the same char is encountered in another string then reduce the count(-1 per encounter)
 * lastly check if any value of map != 0, as that mean strings are not anagram thus return false
 * else return true, because they must be anagrams if they passed the previous checks.
 * 
 * Time:  O(n)
 * Space: O(n)
 * 
 */

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        if (s.length() == 0 && t.length() == 0)
            return true;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }
        for (int i : map.values()) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
