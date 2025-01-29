package LeetCode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium15 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    // Medium 15. 3Sum
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    if (sum < 0)
                        start++;
                    else if (sum > 0)
                        end--;
                    else {
                        result.add(Arrays.asList(nums[i], nums[start++], nums[end--]));
                        while (start < end && nums[start] == nums[start - 1])
                            start++;
                    }
                }
            }
        }
        return result;
    }

}
