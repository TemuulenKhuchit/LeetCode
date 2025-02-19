package LeetCode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Medium1415 {

    private List<String> happyStrings = new ArrayList<>();
    private int n;
    private int k;

    public static void main(String[] args) {
        Medium1415 obj = new Medium1415();
        System.out.println(obj.getHappyString(1, 3));
    }

    public String getHappyString(int n, int k) {
        this.n = n;
        this.k = k;

        backtrack("");
        if (happyStrings.size() < k)
            return "";
        return happyStrings.get(k - 1);
    }

    private void backtrack(String path) {
        if (happyStrings.size() == k)
            return;

        if (path.length() == n) {
            happyStrings.add(path);
            return;
        }

        for (char c = 'a'; c <= 'c'; c++) {
            if (!path.isEmpty() && path.charAt(path.length() - 1) == c)
                continue;
            backtrack(path + c);
        }
    }
}
