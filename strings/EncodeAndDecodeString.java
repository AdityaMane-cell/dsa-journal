package strings;

/*
 * Problem: Encode and Decode Strings
 * Difficulty: Medium
 * Topic: String
 * Pattern: Serialization / deserialization
 *
 * Approach:
 * Simply use stringbuilder's append to encode the string in format{<len></:><word>} 
 * where "/:" is delimiter
 * Now Assuming that above encoded string is passed for decoding
 * extract len word the word (it might not always be units. ex-234)
 * Then check for delimiter to ensure that the digit just recorder where not part of the string.
 * Once delimiter are confirmed. Simply add the sliced string into the result array.
 * 
 *
 * Time:  O(n * k)
 * Space: O(n)
 * 
 */

import java.util.ArrayList;

public class EncodeAndDecodeString {
    public String encode(String arr[]) {
        StringBuilder encoded = new StringBuilder();
        for (String str : arr) {
            encoded.append(str.length()).append("/:").append(str);
        }
        return encoded.toString();
    }

    public ArrayList<String> decode(String s) {
        ArrayList<String> result = new ArrayList<>();
        int len = 0;

        int i = 0;
        while (i < s.length()) {
            // what if the number isn't there
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                len = len * 10 + (int) (s.charAt(i) - '0');
                i++;
            }
            if (i < s.length() - 1 && s.charAt(i) == '/' && s.charAt(i + 1) == ':') {
                i += 2;
                String word = s.substring(i, i + len);
                result.add(word);
                i += len;
                len = 0;
            } else {
                // what if the delimiter does not exist

            }
        }

        return result;
    }
}
