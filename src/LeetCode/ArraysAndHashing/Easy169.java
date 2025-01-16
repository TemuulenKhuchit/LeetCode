package LeetCode.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class Easy169 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    // Easy 169. Majority Element
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int numVal = map.getOrDefault(num, 0) + 1;
            map.put(num, numVal);
            if (numVal > nums.length / 2)
                return num;
        }
        return 0;
    }

}
