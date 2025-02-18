package LeetCode.Backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Medium17 {

    private List<String> res = new ArrayList<>();
    private Map<Character, String> map = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );
    private String digits;

    public static void main(String[] args) {
        Medium17 obj = new Medium17();
        System.out.println(obj.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return res;
        this.digits = digits;
        backtrack(0, new StringBuilder());
        return res;
    }

    private void backtrack(int index, StringBuilder path) {
        if (path.length() == digits.length()) {
            res.add(path.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));
        for (char c : letters.toCharArray()) {
            path.append(c);
            backtrack(index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
