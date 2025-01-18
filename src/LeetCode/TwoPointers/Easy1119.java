package LeetCode.TwoPointers;

public class Easy1119 {

    public static void main(String[] args) {
        System.out.println(removeVowels("leetcodeisacommunityforcoders"));
    }

    // Easy 1119. Remove Vowels from a String
    public static String removeVowels(String s) {
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray())
            if (!isVowel(c))
                str.append(c);
        return str.toString();
    }

    public static boolean isVowel(char c) {
        return c == 'A' || c == 'a' || c == 'E' || c == 'e' ||
                c == 'I' || c == 'i' || c == 'O' || c == 'o' || c == 'U' || c == 'u';
    }

}
