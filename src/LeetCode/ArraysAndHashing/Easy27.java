package LeetCode.ArraysAndHashing;

public class Easy27 {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    // Easy 27. Remove Element
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            }
            else i++;
        }
        return n;
    }

}
