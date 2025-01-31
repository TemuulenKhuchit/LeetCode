package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Medium3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    // Medium 3. Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int n = s.length();

        for (int right = 0, left = 0; right < n; right++) {
            if (map.containsKey(s.charAt(right)))
                left = Math.max(left, map.get(s.charAt(right)));
            res = Math.max(res, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }

        return res;
    }

}
