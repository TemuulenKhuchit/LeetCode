package LeetCode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Medium39 {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    // Medium 39. Combination Sum
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            curr.add(candidates[i]);
            findCombinations(i, remain - candidates[i], curr, res, candidates);
            curr.remove(curr.size() - 1);
        }
    }

}
