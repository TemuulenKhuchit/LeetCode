package Weekly.Contest429;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Question1 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7};
        System.out.println(minimumOperations(nums));
    }

    public static int minimumOperations(int[] nums) {
        boolean isDistinct = true;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int val = map.getOrDefault(num, 0) + 1;
            map.put(num, val);
            if (val > 1)
                isDistinct = false;
        }

        if (isDistinct)
            return 0;

        int removedQty = 0;

        while (removedQty * 3 < nums.length && !isDistinct) {
            removedQty++;
            int el1 = removedQty * 3 - 3;
            int el2 = removedQty * 3 - 2;
            int el3 = removedQty * 3 - 1;

//            map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

            if (el1 < nums.length)
                map.put(nums[el1], map.getOrDefault(nums[el1], 1) - 1);
            if (el2 < nums.length)
                map.put(nums[el2], map.getOrDefault(nums[el2], 1) - 1);
            if (el3 < nums.length)
                map.put(nums[el3], map.getOrDefault(nums[el3], 1) - 1);

//            System.out.print(removedQty + ", ");
//            System.out.println(Collections.max(map.values()));
//            map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
            if (Collections.max(map.values()) <= 1)
                isDistinct = true;
        }

        return removedQty;
    }
}
