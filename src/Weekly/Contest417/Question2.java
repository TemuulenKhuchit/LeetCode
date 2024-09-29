package Weekly.Contest417;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Question2 {

    public static void main(String[] args) {
        System.out.println(countSubstrings("aeioqq", 1));
        System.out.println(countSubstrings("aeiou", 0));
        System.out.println(countSubstrings("ieaouqqieaouqq", 1));
    }

    public static int countSubstrings(String word, int k) {
        int result = 0;
        int len = word.length();
        Set<Character> setVowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < len; i++) {
            Set<Character> curVowels = new HashSet<>();
            int giiguulegchToo = 0;

            for (int j = i; j < len; j++) {
                char c = word.charAt(j);
                if (setVowels.contains(c)) {
                    curVowels.add(c);
                } else if (Character.isLetter(c)) {
                    giiguulegchToo++;
                    if (giiguulegchToo > k) {
                        break;
                    }
                } else {
                    continue;
                }

                if (giiguulegchToo == k && curVowels.size() == 5) {
                    result++;
                }
            }
        }

        return result;
    }

}
