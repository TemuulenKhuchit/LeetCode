package LeetCode.Backtrack;

import LeetCode.Algorithms.QuickSort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Medium698 {

    public static void main(String[] args) {
        Medium698 obj = new Medium698();
        System.out.println(obj.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }

    // Medium 698. Partition to K Equal Sum Subsets
    private int[] nums;
    private char[] used;
    private Map<String, Boolean> memo = new HashMap<>();
    private int target;
    private int k;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        this.used = new char[nums.length];
        this.k = k;

        Arrays.fill(used, '0');

        int sum = 0;
        for (int num : nums)
            sum += num;

        target = sum / k;
        if (target * k != sum)
            return false;

        Arrays.sort(nums);
        reverse(nums);

        return backtrack(0, 0, 0);
    }

    private boolean backtrack(int index, int count, int currSum) {
        if (count == k - 1)
            return true;

        if (currSum > target)
            return false;

        String usedStr = new String(used);
        if (memo.containsKey(usedStr))
            return memo.get(usedStr);

        if (currSum == target) {
            boolean ans = backtrack(0, count + 1, 0);
            memo.put(usedStr, ans);
            return ans;
        }

        for (int i = index; i < nums.length; i++) {
            if (used[i] == '1')
                continue;
            used[i] = '1';
            if (backtrack(i + 1, count, currSum + nums[i]))
                return true;
            used[i] = '0';
        }

        memo.put(usedStr, false);
        return false;
    }

    void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
