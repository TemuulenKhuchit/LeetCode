package LeetCode.PrefixSum;

import java.util.List;

public class Easy3364 {

    public static void main(String[] args) {
        System.out.println(minimumSumSubarray(List.of(3, -2, 1, 4), 2, 3));
    }

    // Easy 3364. Minimum Positive Sum Subarray
    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int sum = 0;
        for (int i = 0; i < l; i++)
            sum += nums.get(i);

        return 0;
    }

}
