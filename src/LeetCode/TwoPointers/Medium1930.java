package LeetCode.TwoPointers;

import java.util.HashSet;
import java.util.Set;

public class Medium1930 {

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }

    // Medium 1930. Unique Length-3 Palindromic Subsequences
    public static int countPalindromicSubsequence(String s) {
        Set<Character> edgeLetters = new HashSet<>();
        Set<String> palindromicWords = new HashSet<>();
        int f = 0;
        while (f < s.length() - 1) {
            if (!edgeLetters.contains(s.charAt(f))) {
                int l = s.length() - 1;
                while (f < l && s.charAt(f) != s.charAt(l))
                    l--;
                edgeLetters.add(s.charAt(f));

                for (int i = f + 1; i < l; i++)
                    palindromicWords.add("" + s.charAt(f) + s.charAt(i) + s.charAt(f));
            }
            f++;
        }
        return palindromicWords.size();
    }

}
