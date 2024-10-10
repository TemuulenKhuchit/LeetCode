package Problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Medium962 {

    public static void main(String[] args) {

        maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5});
        maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1});
        maxWidthRamp(new int[]{3, 3, 3});
        maxWidthRamp(new int[]{2, 7, 2, 2, 7});
    }

    //    Log n
    public static int maxWidthRamp(int[] nums) {
        int low = 1, high = nums.length - 1, res = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(nums, mid)) {
                res = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return res;
    }

    private static boolean possible(int[] nums, int width) {
        int i = 0, j = width;
        int min = nums[i];
        while (j < nums.length) {
            if (nums[j] >= min) return true;
            j++;
            min = Math.min(min, nums[++i]);
        }
        return false;
    }

    //    O(n)
    public static int maxWidthRamp2(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
            if (stack.isEmpty() || nums[i] < nums[stack.peek()])
                stack.push(i);

        int maxWidth = 0;
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[j] >= nums[stack.peek()]) {
                int i = stack.pop();
                maxWidth = Math.max(maxWidth, j - i);
            }
        }

        return maxWidth;
    }

    //    O(n*n)
    public static int maxWidthRamp3(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] <= nums[j] && nums[j] - nums[i] >= 0)
                    max = Math.max(max, j - i);

        return max;
    }

}
