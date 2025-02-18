package LeetCode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Medium131 {

    private List<List<String>> res = new ArrayList<>();
    private String s;

    public static void main(String[] args) {
        Medium131 obj = new Medium131();
        System.out.println(obj.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        this.s = s;
        findPalindromes(0, new ArrayList<>());
        return res;
    }

    private void findPalindromes(int start, List<String> curr) {
        if (start == s.length())
            res.add(new ArrayList<>(curr));

        for (int end = start; end < s.length(); end++) {
            if (!isPalindrome(start, end))
                continue;
            curr.add(s.substring(start, end + 1));
            findPalindromes(end + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }

    private boolean isPalindrome(int start, int end) {
        while (start < end)
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        return true;
    }
}
