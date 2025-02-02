package Weekly.Contest435;

import java.util.Arrays;

public class Question1 {

    public static void main(String[] args) {
        System.out.println(maxDifference("aaaaabbc"));
    }

    public static int maxDifference(String s) {
        int[] letters = new int[26];
        int minEven = Integer.MAX_VALUE;
        int maxOdd = 0;
        for (char c : s.toCharArray())
            letters[c - 'a']++;
        for (int num : letters) {
            if (num > 0) {
                if (num % 2 == 0)
                    minEven = Math.min(minEven, num);
                else maxOdd = Math.max(maxOdd, num);
            }
        }

        return maxOdd - minEven;
    }
}
