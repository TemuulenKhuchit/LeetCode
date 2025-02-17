package LeetCode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Medium78 {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    // Medium 78. Subsets
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findSubnets(0, new ArrayList<>(), res, nums);
        return res;
    }

    private static void findSubnets(int idx, List<Integer> curr, List<List<Integer>> res, int[] nums) {
        res.add(new ArrayList<>(curr));

        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            findSubnets(i + 1, curr, res, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
