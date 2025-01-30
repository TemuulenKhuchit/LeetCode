package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Easy219 {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }

    // Easy 219. Contains Duplicate II
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                return true;
            if (set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }

}
