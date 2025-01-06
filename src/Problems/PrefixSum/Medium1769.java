package Problems.PrefixSum;

import java.util.Arrays;

public class Medium1769 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("001011")));
    }

    // Medium 1769. Minimum Number of Operations to Move All Balls to Each Box
    // Approach 1: Brute Force
    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j && boxes.charAt(j) == '1')
                    answer[i] += Math.abs(j - i);

        return answer;
    }

    // Approach 2: Prefix Sum
    public int[] minOperations2(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        int leftCumSum = 0, rightCumSum = 0;
        int leftBalls = 0, rightBalls = 0;

        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                if (i > 0) {
                    leftCumSum += i;
                    leftBalls++;
                }
                if (i < n - 1) {
                    rightCumSum += n - 1 - i;
                    rightBalls++;
                }
            }
        }
        answer[0] = leftCumSum;
        for (int i = 1; i < n - 1; i++) {
            if (leftBalls == 0)
                break;
            answer[i] += answer[i - 1] - leftBalls;
            if (boxes.charAt(i) == '1')
                leftBalls--;
        }
        answer[n - 1] = rightCumSum;
        int last = answer[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (rightBalls == 0)
                break;
            answer[i] += last - rightBalls;
            last -= rightBalls;
            if (boxes.charAt(i) == '1')
                rightBalls--;
        }
        return answer;
    }
}
