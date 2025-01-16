package LeetCode.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class Easy409 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    // Easy 409. Longest Palindrome
    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int oddCount = 0;
        for (char c : s.toCharArray()) {
            int val = map.getOrDefault(c, 0) + 1;
            oddCount += (val % 2 == 1) ? 1 : -1;
            map.put(c, val);
        }
        if (oddCount <= 1)
            return s.length();
        return s.length() - oddCount + 1;
    }

}
