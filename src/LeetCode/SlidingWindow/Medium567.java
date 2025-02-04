package LeetCode.SlidingWindow;

import java.util.Arrays;

public class Medium567 {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

    // Medium 567. Permutation in String
    public static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2)
            return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < n1; i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n2 - n1; i++) {
            if (matches(arr1, arr2))
                return true;
            arr2[s2.charAt(i + n1) - 'a']++;
            arr2[s2.charAt(i) - 'a']--;
        }
        return matches(arr1, arr2);
    }

    public static boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }
}
