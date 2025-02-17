package LeetCode.Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium90 {

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }

    // Medium 90. Subsets II
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        findSubsets(0, res, new ArrayList<>(), nums);
        return res;
    }

    private static void findSubsets(int idx, List<List<Integer>> res, List<Integer> curr, int[] nums) {
        res.add(new ArrayList<>(curr));

        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i] == nums[i - 1])
                continue;
            curr.add(nums[i]);
            findSubsets(i + 1, res, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
