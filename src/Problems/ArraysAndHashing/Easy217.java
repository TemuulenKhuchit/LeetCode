package Problems.ArraysAndHashing;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Easy217 {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    // Easy 217. Contains Duplicate
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return nums.length != set.size();
    }
}
