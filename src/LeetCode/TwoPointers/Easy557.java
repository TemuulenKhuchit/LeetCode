package LeetCode.TwoPointers;

public class Easy557 {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    // Easy 557. Reverse Words in a String III
    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            char[] chars = word.toCharArray();
            reverse(chars);
            if (!result.isEmpty())
                result.append(" ");
            result.append(chars);
        }
        return result.toString();
    }

    public static void reverse(char[] chars) {
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }

}
