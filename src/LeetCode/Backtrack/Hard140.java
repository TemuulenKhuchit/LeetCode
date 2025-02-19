package LeetCode.Backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hard140 {
    private List<String> res = new ArrayList<>();
    private Set<String> wordSet;
    private String s;

    public static void main(String[] args) {
        Hard140 obj = new Hard140();
        System.out.println(obj.wordBreak("catsanddog", new ArrayList<>(List.of("cat", "cats", "and", "sand", "dog"))));
    }

    // Hard 140. Word Break II
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        this.s = s;

        backtrack(0, new StringBuilder());

        return res;
    }

    private void backtrack(int start, StringBuilder curr) {
        if (start == s.length()) {
            res.add(curr.toString().trim());
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String word = s.substring(start, end);
            if (!wordSet.contains(word))
                continue;

            int currLen = curr.length();
            curr.append(word).append(' ');

            backtrack(end, curr);

            curr.setLength(currLen);
        }
    }
}
