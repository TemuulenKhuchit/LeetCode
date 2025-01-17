package LeetCode.TwoPointers;

public class Easy541 {

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }

    // Easy 541. Reverse String II
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i += 2 * k) {
            int start = i;
            int end = Math.min(start - 1 + k, n - 1);
            reverse(chars, start, end);
        }
        return new String(chars);
    }

    public static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }

}
