package LeetCode.TwoPointers;

import java.util.Arrays;

public class Medium881 {

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    }

    // Medium 881. Boats to Save People
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int boats = 0;
        while (i <= j) {
            boats++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }
        return boats;
    }

}
