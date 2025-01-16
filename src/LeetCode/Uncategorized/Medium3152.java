package LeetCode.Uncategorized;

import java.util.Arrays;

public class Medium3152 {

    public static void main(String[] args) {
        int[][] queries = {{0, 2}, {2, 3}};
        System.out.println(Arrays.toString(isArraySpecial(new int[]{4, 3, 1, 6}, queries)));
    }

    // Medium 3152. Special Array II
    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] prefix = new int[nums.length];
        prefix[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                // new violative index found
                prefix[i] = prefix[i - 1] + 1;
            }
            else {
                prefix[i] = prefix[i - 1];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];

            ans[i] = prefix[end] - prefix[start] == 0;
        }

        return ans;
    }
}
