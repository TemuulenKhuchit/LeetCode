package Weekly.Contest418;

import java.util.Arrays;

public class Question1 {
    public static void main(String[] args) {
        System.out.println(maxGoodNumber(new int[]{1, 2, 3}));
        System.out.println(maxGoodNumber(new int[]{2, 8, 16}));
    }

    public static int maxGoodNumber(int[] nums) {

        String binaryValue = Arrays.stream(nums)
                .boxed()
                .map(Integer::toBinaryString)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .reduce("", (a, b) -> a + b);

        return Integer.parseInt(binaryValue, 2);
    }
}
