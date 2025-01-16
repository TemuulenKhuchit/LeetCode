package LeetCode.ArraysAndHashing;

public class Easy266 {

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("code"));
    }

    // Easy 266. Palindrome Permutation
    public static boolean canPermutePalindrome(String s) {
        int[] letters = new int[26];
        for (char c : s.toCharArray())
            letters[c - 'a']++;
        boolean hasFoundOdd = false;
        for (int letter : letters) {
            if (letter % 2 == 1) {
                if (hasFoundOdd)
                    return false;
                hasFoundOdd = true;
            }
        }
        return true;
    }

}
