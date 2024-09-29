package Biweekly.Contest140;

import java.util.Arrays;
import java.util.Collections;

public class Question2 {
    public static void main(String[] args) {
        System.out.println(maximumTotalSum(new int[]{2, 3, 4, 3}));
        System.out.println(maximumTotalSum(new int[]{15, 10}));
        System.out.println(maximumTotalSum(new int[]{2, 2, 1}));
        System.out.println(maximumTotalSum(new int[]{6, 6, 6, 3, 7, 2, 6, 5}));
    }

    public static long maximumTotalSum(int[] maximumHeight) {
        maximumHeight = Arrays.stream(maximumHeight)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        long sum = maximumHeight[0];
        for (int i = 1; i < maximumHeight.length; i++) {
            if (maximumHeight[i - 1] <= maximumHeight[i]) {
                if (maximumHeight[i - 1] - 1 == 0)
                    return -1;
                maximumHeight[i] = maximumHeight[i - 1] - 1;
            }
            sum += maximumHeight[i];
        }
        return sum;
    }
}