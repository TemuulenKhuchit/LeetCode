package Weekly.Contest434;

import java.util.HashSet;
import java.util.Set;

public class Question3 {

    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1, 2, 3, 4, 5, 6}, 1));
    }

    public static int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        int kCount = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == k)
                kCount++;
            numSet.add(nums[i]);
        }
        int max = 0;
        for (int num : numSet) {
            if (num != k) {
                int[] temp = new int[n];
                for (int i = 0; i < n; i++) {
                    if (nums[i] == num) {
                        temp[i] = 1;
                    }
                    else if (nums[i] == k) {
                        temp[i] = -1;
                    }
                    else {
                        temp[i] = 0;
                    }
                }
                int localMax = 0;
                int globalMax = Integer.MIN_VALUE;
                for (int value : temp) {
                    localMax = Math.max(value, localMax + value);
                    globalMax = Math.max(globalMax, localMax);
                }
                max = Math.max(max, globalMax);
            }
        }
        return kCount + Math.max(0, max);
    }
}
