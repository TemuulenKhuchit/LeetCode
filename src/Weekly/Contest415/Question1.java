package Weekly.Contest415;

import java.util.ArrayList;
import java.util.List;

public class Question1 {
    public static void main(String[] args) {
        long a = maxScore(new int[]{3, 2, 5, 6}, new int[]{2, -6, 4, -5, -3, 2, -7});
        System.out.println(a);
    }

    public static int[] getSneakyNumbers(int[] nums) {
        List<Integer> newList = new ArrayList<>();
        List<Integer> returnList = new ArrayList<>();
        for (int num : nums) {
            if (newList.contains(num))
                returnList.add(num);
            else
                newList.add(num);
        }
        int[] array = returnList.stream().mapToInt(i -> i).toArray();
        return array;
    }

    public static long maxScore(int[] a, int[] b) {


        return 0L;
    }
}