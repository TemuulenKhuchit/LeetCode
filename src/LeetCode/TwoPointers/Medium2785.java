package LeetCode.TwoPointers;

import java.util.Arrays;

public class Medium2785 {

    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde"));
    }

    // Medium 2785. Sort Vowels in a String
    public static String sortVowels(String s) {
        int n = s.length();
        char[] chars = new char[n];
        int currIndex = 0;
        int vowelsCount = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                chars[currIndex++] = c;
                vowelsCount++;
            }
        }
        Arrays.sort(chars);
        currIndex = n - vowelsCount;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!isVowel(s.charAt(i)))
                result.append(s.charAt(i));
            else result.append(chars[currIndex++]);
        }
        return result.toString();
    }

    public static boolean isVowel(char c) {
        return c == 'A' || c == 'a' || c == 'E' || c == 'e' ||
                c == 'I' || c == 'i' || c == 'O' || c == 'o' || c == 'U' || c == 'u';
    }

}
