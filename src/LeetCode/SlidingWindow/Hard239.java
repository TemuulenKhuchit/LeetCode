package LeetCode.SlidingWindow;

import java.util.*;

public class Hard239 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    // Hard 239. Sliding Window Maximum
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for (int r = 0, l = 0; r < nums.length; r++) {
            while (!dq.isEmpty() && nums[r] > nums[dq.peekLast()])
                dq.pollLast();
            dq.offerLast(r);

            if (l > dq.peekFirst())
                dq.pollFirst();

            if (r + 1 >= k) {
                res.add(nums[dq.peekFirst()]);
                l++;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
