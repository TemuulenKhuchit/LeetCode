package Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Medium2461 {

    public static void main(String[] args) {
        maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3);
        maximumSubarraySum(new int[]{4, 4, 4}, 3);
    }

    // 2461. Maximum Sum of Distinct Subarrays With Length K
    public static long maximumSubarraySum(int[] nums, int k) {
        long result = 0;
        long sum = 0;
        int begin = 0;
        int end = 0;

        Map<Integer, Integer> numToIndex = new HashMap<>();

        while (end < nums.length) {
            int currNum = nums[end];
            int lastOccurrence = numToIndex.getOrDefault(currNum, -1);

            while (begin <= lastOccurrence || end - begin + 1 > k) {
                sum -= nums[begin];
                begin++;
            }
            numToIndex.put(currNum, end);
            sum += nums[end];
            if (end - begin + 1 == k)
                result = Math.max(result, sum);
            end++;
        }

        System.out.println(result);
        return result;
    }

    public static long maximumSubarraySum2(int[] nums, int k) {
        long result = 0;
        long currSum = 0;
        int begin = 0;
        int end = 0;

        Map<Integer, Integer> numsToIndex = new HashMap<>();

        while (end < nums.length) {
            int currNum = nums[end];
            int lastOccurrence = numsToIndex.getOrDefault(currNum, -1);

            while (begin <= lastOccurrence || end - begin + 1 > k) {
                currSum -= nums[begin];
                begin++;
            }
            currSum += nums[end];
            numsToIndex.put(nums[end], end);
            if (end - begin + 1 == k)
                result = Math.max(result, currSum);
            end++;
        }

        return result;
    }

}
