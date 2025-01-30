package LeetCode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium18 {

    public static void main(String[] args) {
        Medium18 m = new Medium18();
        m.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }

    // Medium 18. 4Sum
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length)
            return res;

        long average_value = target / k;

        if (nums[start] > average_value || average_value > nums[nums.length - 1])
            return res;

        if (k == 2)
            return twoSum(nums, target, start);

        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int low = start;
        int high = nums.length - 1;

        while (low < high) {
            int currSum = nums[low] + nums[high];
            if (currSum < target || (low > start && nums[low] == nums[low - 1]))
                low++;
            else if (currSum > target || (high < nums.length - 1 && nums[high] == nums[high + 1]))
                high--;
            else res.add(Arrays.asList(nums[low++], nums[high--]));
        }

        return res;
    }

}
