package LeetCode.ArraysAndHashing;

import LeetCode.Algorithms.QuickSort;

public class Medium75 {

    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 0, 2, 1, 1});
    }

    // Medium 75. Sort Colors
    public static void sortColors(int[] nums) {
        int p0 = 0;
        int curr = 0;
        int p2 = nums.length - 1;

        while (curr <= p2) {
            if (nums[curr] == 0) {
                QuickSort.swap(nums, curr, p0);
                p0++;
                curr++;
            }
            else if (nums[curr] == 2) {
                QuickSort.swap(nums, curr, p2);
                p2--;
            }
            else curr++;
        }
    }

}
