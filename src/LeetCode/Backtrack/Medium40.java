package LeetCode.Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium40 {

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    // Medium 40. Combination Sum II
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        findCombinations(0, target, new ArrayList<>(), res, candidates);
        return res;
    }

    private static void findCombinations(
            int idx, int remain, List<Integer> curr, List<List<Integer>> res, int[] candidates) {
        if (remain == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (remain < 0)
            return;

        for (int i = idx; i < candidates.length; i++) {
            if (i != idx && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > remain)
                break;
            curr.add(candidates[i]);
            findCombinations(i + 1, remain - candidates[i], curr, res, candidates);
            curr.remove(curr.size() - 1);
        }
    }

}
