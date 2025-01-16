package Weekly.Contest427;

import java.util.Arrays;

public class Question1 {

    public static void main(String[] args) {
        Question1 obj = new Question1();
        System.out.println(Arrays.toString(obj.constructTransformedArray(new int[]{3, -2, 1, 1})));
    }

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) result[i] = nums[i];
            else if (nums[i] > 0) {
                int pos = (i + nums[i]) % n;
                result[i] = nums[pos];
            }
            else if (nums[i] < 0) {
                int pos = (i + nums[i]) % n;
                if (pos < 0) pos += n;
                result[i] = nums[pos];
            }
        }

        return result;
    }
}
