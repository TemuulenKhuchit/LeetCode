package LeetCode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Medium46 {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    // Medium 46. Permutations
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findPermutes(new ArrayList<>(), res, nums);
        return res;
    }

    private static void findPermutes(List<Integer> curr, List<List<Integer>> res, int[] nums) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int num : nums) {
            if (curr.contains(num))
                continue;
            curr.add(num);
            findPermutes(curr, res, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
