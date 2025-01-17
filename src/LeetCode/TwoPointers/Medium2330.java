package LeetCode.TwoPointers;

public class Medium2330 {

    public static void main(String[] args) {
        System.out.println(makePalindrome("abcdba"));
    }

    // Medium 2330. Valid Palindrome IV
    public static boolean makePalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        int operationCount = 0;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                if (operationCount < 2)
                    operationCount++;
                else return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
