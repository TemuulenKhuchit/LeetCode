package Problems;

import java.util.*;
import java.util.stream.Collectors;

public class Medium2554 {

    public static void main(String[] args) {
        System.out.println(maxCount(new int[]{1, 6, 5}, 5, 6));
        System.out.println(maxCount(new int[]{1, 2, 3, 4, 5, 6, 7}, 8, 1));
        System.out.println(maxCount(new int[]{11}, 7, 50));
    }

    // Medium 2554. Maximum Number of Integers to Choose From a Range I
    public static int maxCount(int[] banned, int n, int maxSum) {
        int count = 0;
        int sum = 0;

//        HashSet<Integer> banSet = Arrays.stream(banned).boxed().collect(Collectors.toCollection(HashSet::new));
        Set<Integer> banSet = new HashSet<>();

        for (int num : banned)
            banSet.add(num);

        for (int i = 1; i <= n; i++) {
            if (banSet.contains(i))
                continue;
            if (sum + i <= maxSum) {
                sum += i;
                count++;
            }
            else return count;
        }

        return count;
    }
}
