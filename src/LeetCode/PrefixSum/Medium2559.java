package LeetCode.PrefixSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Medium2559 {

    public static void main(String[] args) {
        String[] words = new String[]{"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = new int[][]{{0, 2}, {1, 4}, {1, 1}};
        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }

    // Medium 2559. Count Vowel Strings in Ranges
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] ps = new int[words.length];
        Set<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));

        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            if (vowels.contains(words[i].charAt(0)) &&
                    vowels.contains(words[i].charAt(words[i].length() - 1)))
                sum++;
            ps[i] = sum;
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (query[0] != 0) ans[i] = ps[query[1]] - ps[query[0] - 1];
            else ans[i] = ps[query[1]];
        }
        return ans;
    }

}
