package LeetCode.TwoPointers;

public class Easy125 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(".,"));
    }

    // Easy 125. Valid Palindrome
    public static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int p1 = 0, p2 = chars.length - 1;

        while (p1 < p2) {
            while (!Character.isLetterOrDigit(chars[p1]) && p1 < chars.length - 1)
                p1++;
            while (!Character.isLetterOrDigit(chars[p2]) && p2 > 0)
                p2--;
            if(chars[p1] != chars[p2] && Character.isLetterOrDigit(chars[p1]) && Character.isLetterOrDigit(chars[p2]))
                return false;
            p1++;
            p2--;
        }

        return true;
    }

    public static boolean isPalindrome2(String s) {
        int n = s.length();
        int start = 0;
        int end = n - 1;
        while (start < end) {
            while (!isValid(s.charAt(start)) && start < n - 1)
                start++;
            while (!isValid(s.charAt(end)) && end > 0)
                end--;
            if (start >= n - 1 || end <= 0)
                break;
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean isValid(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
