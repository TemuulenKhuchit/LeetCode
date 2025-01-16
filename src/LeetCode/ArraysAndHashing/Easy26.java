package LeetCode.ArraysAndHashing;

public class Easy26 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    // Easy 26. Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        int changeInd = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[changeInd - 1] != nums[i]) {
                nums[changeInd] = nums[i];
                changeInd++;
            }
        }
        return changeInd;
    }

}
