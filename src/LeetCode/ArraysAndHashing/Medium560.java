package LeetCode.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class Medium560 {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }

    // Medium 560. Subarray Sum Equals K
    public static int subarraySum(int[] nums, int k) {
        int sum = 0, total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            total += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return total;
    }

}
