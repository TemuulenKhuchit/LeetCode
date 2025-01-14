package Problems.ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class Easy2357 {

    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1, 5, 0, 3, 5}));
    }

    // Easy 2357. Make Array Zero by Subtracting Equal Amounts
    public static int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            if (num > 0)
                set.add(num);
        return set.size();
    }

}
