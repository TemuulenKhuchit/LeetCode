package LeetCode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Medium216 {

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }

    // Medium 216. Combination Sum III
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        findCombinations(1, n, new ArrayList<>(), res, k);
        return res;
    }

    private static void findCombinations(
            int num, int remain, List<Integer> curr, List<List<Integer>> res, int k) {
        if (curr.size() == k) {
            if (remain == 0)
                res.add(new ArrayList<>(curr));
            return;
        }
        if (remain < 0)
            return;

        for (int i = num; i < 10; i++) {
            curr.add(i);
            findCombinations(i + 1, remain - i, curr, res, k);
            curr.remove(curr.size() - 1);
        }
    }

}
