package Problems;

import java.util.Arrays;

public class Medium2593 {
    public static void main(String[] args) {
        System.out.println(findScore(new int[]{2, 1, 3, 4, 5, 2}));
        System.out.println(findScore(new int[]{2, 3, 5, 1, 3, 2}));
    }

    // Medium 2593. Find Score of an Array After Marking All Elements
    public static long findScore(int[] nums) {
        long sum = 0;
        int[] visited = new int[nums.length];
        int visitedQty = 0;

        while (visitedQty < nums.length) {
            int minIndex = -1;
            for (int i = 0; i < nums.length; i++)
                if ((minIndex == -1 || nums[i] < nums[minIndex]) && visited[i] == 0)
                    minIndex = i;

            visited[minIndex] = 1;
            sum += nums[minIndex];
            if (minIndex - 1 >= 0) visited[minIndex - 1] = 1;
            if (minIndex + 1 < nums.length) visited[minIndex + 1] = 1;
            visitedQty = Arrays.stream(visited).sum();
        }

        return sum;
    }
}
