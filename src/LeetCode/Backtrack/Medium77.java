package LeetCode.Backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Medium77 {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    // Medium 77. Combinations
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        findCombinations(1, new ArrayList<>(), res, n, k);
        return res;
    }

    private static void findCombinations(int num, List<Integer> curr, List<List<Integer>> res, int n, int k) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = num; i <= n; i++) {
            curr.add(i);
            findCombinations(i + 1, curr, res, n, k);
            curr.remove(curr.size() - 1);
        }
    }
}
