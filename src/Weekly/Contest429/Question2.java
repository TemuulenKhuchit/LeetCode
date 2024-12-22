package Weekly.Contest429;

import java.util.Arrays;

public class Question2 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 3, 4};
        int k1 = 2;
        System.out.println(maxDistinctElements(nums1, k1));

        int[] nums2 = {4, 4, 4, 4};
        int k2 = 1;
        System.out.println(maxDistinctElements(nums2, k2));
    }

    public static int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);

        long lastUsed = Long.MIN_VALUE;
        int distinctNums = 0;

        for (int num : nums) {
            long changedValue = Math.max(lastUsed + 1, (long) num - k);
            if (changedValue <= (long) num + k) {
                distinctNums++;
                lastUsed = changedValue;
            }
        }

        return distinctNums;
    }

}
