package LeetCode.TwoPointers;

public class Medium11 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    // Medium 11. Container With Most Water
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = calcSize(height, i, j);
        while (i < j) {
            if (height[i] > height[j])
                j--;
            else i++;
            max = Math.max(max, calcSize(height, i, j));
        }
        return max;
    }

    public static int calcSize(int[] height, int i, int j) {
        return Math.min(height[i], height[j]) * (j - i);
    }

}
