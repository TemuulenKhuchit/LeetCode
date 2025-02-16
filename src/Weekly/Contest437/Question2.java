package Weekly.Contest437;

import java.util.Arrays;

public class Question2 {

    public static void main(String[] args) {
        System.out.println(maxWeight(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

    public static long maxWeight(int[] pizzas) {
        int n = pizzas.length;
        Arrays.sort(pizzas);

        int m = n / 4;
        int oddDays = (m + 1) / 2;
        int evenDays = m - oddDays;

        long total = 0;

        for (int i = 0; i < oddDays; i++)
            total += pizzas[n - 1 - i];

        for (int j = 0; j < evenDays; j++) {
            int idx = oddDays + 2 * j + 1;
            total += pizzas[n - 1 - idx];
        }

        return total;
    }
}
