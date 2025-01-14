package Problems.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class Easy219 {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }

    // Easy 219. Contains Duplicate II
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k)
                return true;
            map.put(nums[i], i);
        }
        return false;
    }

}
