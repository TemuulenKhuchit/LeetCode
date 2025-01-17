package LeetCode.TwoPointers;

public class Easy345 {

    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
    }

    // Easy 345. Reverse Vowels of a String
    public static String reverseVowels(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        char[] chars = s.toCharArray();

        while (i < j) {
            while (i + 1 < n && !isVowel(chars[i]))
                i++;
            while (j > 0 && !isVowel(chars[j]))
                j--;
            if (i < j)
                swap(chars, i, j);
            i++;
            j--;
        }
        return new String(chars);
    }

    public static boolean isVowel(char c) {
        return c == 'A' || c == 'a' || c == 'E' || c == 'e' ||
                c == 'I' || c == 'i' || c == 'O' || c == 'o' || c == 'U' || c == 'u';
    }

    public static void swap (char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
